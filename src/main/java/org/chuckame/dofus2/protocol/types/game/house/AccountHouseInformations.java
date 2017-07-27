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
public class AccountHouseInformations implements INetworkType {
	public static final short TYPE_ID = 390;
	
	private int houseId;
	private short modelId;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	
	public AccountHouseInformations() {
	}
	
	public AccountHouseInformations(int houseId, short modelId, short worldX, short worldY, int mapId, short subAreaId) {
		this.houseId = houseId;
		this.modelId = modelId;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
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
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.mapId = reader.readInt();
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.houseId);
		writer.writeShort(this.modelId);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
	}
}