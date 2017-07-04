package org.michocko.dofus2.protocol.messages.game.prism;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismSettingsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6437;
	
	private short subAreaId;
	private byte startDefenseTime;
	
	public PrismSettingsRequestMessage() {
	}
	
	public PrismSettingsRequestMessage(short subAreaId, byte startDefenseTime) {
		this.subAreaId = subAreaId;
		this.startDefenseTime = startDefenseTime;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.startDefenseTime = reader.readSByte();
		if (startDefenseTime < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on startDefenseTime = %s, it doesn't respect the following condition : startDefenseTime < 0", startDefenseTime));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeSByte(this.startDefenseTime);
	}
}