package org.chuckame.dofus2.protocol.types.game.house;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class HouseInformationsInside implements INetworkType {
	public static final short TYPE_ID = 218;
	
	private int houseId;
	private short modelId;
	private int ownerId;
	private String ownerName;
	private short worldX;
	private short worldY;
	private long price;
	private boolean isLocked;
	
	public HouseInformationsInside() {
	}
	
	public HouseInformationsInside(int houseId, short modelId, int ownerId, String ownerName, short worldX, short worldY, long price, boolean isLocked) {
		this.houseId = houseId;
		this.modelId = modelId;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.worldX = worldX;
		this.worldY = worldY;
		this.price = price;
		this.isLocked = isLocked;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.houseId = reader.readInt();
		if (houseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on houseId = %s, it doesn't respect the following condition : houseId < 0", houseId));
		this.modelId = reader.readShort();
		if (modelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on modelId = %s, it doesn't respect the following condition : modelId < 0", modelId));
		this.ownerId = reader.readInt();
		this.ownerName = reader.readUTF();
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.price = reader.readUInt();
		if (price < 0 || price > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0 || price > 4.294967295E9", price));
		this.isLocked = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.houseId);
		writer.writeShort(this.modelId);
		writer.writeInt(this.ownerId);
		writer.writeUTF(this.ownerName);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeUInt(this.price);
		writer.writeBoolean(this.isLocked);
	}
}