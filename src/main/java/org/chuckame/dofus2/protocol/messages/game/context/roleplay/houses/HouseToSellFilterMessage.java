package org.chuckame.dofus2.protocol.messages.game.context.roleplay.houses;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseToSellFilterMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6137;
	
	private int areaId;
	private byte atLeastNbRoom;
	private byte atLeastNbChest;
	private short skillRequested;
	private int maxPrice;
	
	public HouseToSellFilterMessage() {
	}
	
	public HouseToSellFilterMessage(int areaId, byte atLeastNbRoom, byte atLeastNbChest, short skillRequested, int maxPrice) {
		this.areaId = areaId;
		this.atLeastNbRoom = atLeastNbRoom;
		this.atLeastNbChest = atLeastNbChest;
		this.skillRequested = skillRequested;
		this.maxPrice = maxPrice;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.areaId = reader.readInt();
		this.atLeastNbRoom = reader.readSByte();
		if (atLeastNbRoom < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on atLeastNbRoom = %s, it doesn't respect the following condition : atLeastNbRoom < 0", atLeastNbRoom));
		this.atLeastNbChest = reader.readSByte();
		if (atLeastNbChest < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on atLeastNbChest = %s, it doesn't respect the following condition : atLeastNbChest < 0", atLeastNbChest));
		this.skillRequested = reader.readShort();
		if (skillRequested < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillRequested = %s, it doesn't respect the following condition : skillRequested < 0", skillRequested));
		this.maxPrice = reader.readInt();
		if (maxPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxPrice = %s, it doesn't respect the following condition : maxPrice < 0", maxPrice));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.areaId);
		writer.writeSByte(this.atLeastNbRoom);
		writer.writeSByte(this.atLeastNbChest);
		writer.writeShort(this.skillRequested);
		writer.writeInt(this.maxPrice);
	}
}