package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LivingObjectChangeSkinRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5725;
	
	private int livingUID;
	private short livingPosition;
	private int skinId;
	
	public LivingObjectChangeSkinRequestMessage() {
	}
	
	public LivingObjectChangeSkinRequestMessage(int livingUID, short livingPosition, int skinId) {
		this.livingUID = livingUID;
		this.livingPosition = livingPosition;
		this.skinId = skinId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.livingUID = reader.readInt();
		if (livingUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on livingUID = %s, it doesn't respect the following condition : livingUID < 0", livingUID));
		this.livingPosition = reader.readByte();
		if (livingPosition < 0 || livingPosition > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on livingPosition = %s, it doesn't respect the following condition : livingPosition < 0 || livingPosition > 255", livingPosition));
		this.skinId = reader.readInt();
		if (skinId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skinId = %s, it doesn't respect the following condition : skinId < 0", skinId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.livingUID);
		writer.writeByte(this.livingPosition);
		writer.writeInt(this.skinId);
	}
}