package org.chuckame.dofus2.protocol.messages.game.basic;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicAckMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6362;
	
	private int seq;
	private short lastPacketId;
	
	public BasicAckMessage() {
	}
	
	public BasicAckMessage(int seq, short lastPacketId) {
		this.seq = seq;
		this.lastPacketId = lastPacketId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.seq = reader.readInt();
		if (seq < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on seq = %s, it doesn't respect the following condition : seq < 0", seq));
		this.lastPacketId = reader.readShort();
		if (lastPacketId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastPacketId = %s, it doesn't respect the following condition : lastPacketId < 0", lastPacketId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.seq);
		writer.writeShort(this.lastPacketId);
	}
}