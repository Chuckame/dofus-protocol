package org.chuckame.dofus2.protocol.messages.game.prism;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismSetSabotagedRefusedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6466;
	
	private short subAreaId;
	private byte reason;
	
	public PrismSetSabotagedRefusedMessage() {
	}
	
	public PrismSetSabotagedRefusedMessage(short subAreaId, byte reason) {
		this.subAreaId = subAreaId;
		this.reason = reason;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.reason = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeSByte(this.reason);
	}
}