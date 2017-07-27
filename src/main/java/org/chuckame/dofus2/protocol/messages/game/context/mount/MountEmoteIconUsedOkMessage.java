package org.chuckame.dofus2.protocol.messages.game.context.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountEmoteIconUsedOkMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5978;
	
	private int mountId;
	private byte reactionType;
	
	public MountEmoteIconUsedOkMessage() {
	}
	
	public MountEmoteIconUsedOkMessage(int mountId, byte reactionType) {
		this.mountId = mountId;
		this.reactionType = reactionType;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mountId = reader.readInt();
		this.reactionType = reader.readSByte();
		if (reactionType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on reactionType = %s, it doesn't respect the following condition : reactionType < 0", reactionType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mountId);
		writer.writeSByte(this.reactionType);
	}
}