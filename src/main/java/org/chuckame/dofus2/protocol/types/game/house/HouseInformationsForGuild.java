package org.chuckame.dofus2.protocol.types.game.house;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class HouseInformationsForGuild implements INetworkType {
	public static final short TYPE_ID = 170;
	
	private int houseId;
	private int modelId;
	private String ownerName;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	private Collection<Integer> skillListIds;
	private long guildshareParams;
	
	public HouseInformationsForGuild() {
	}
	
	public HouseInformationsForGuild(int houseId, int modelId, String ownerName, short worldX, short worldY, int mapId, short subAreaId, Collection<Integer> skillListIds, long guildshareParams) {
		this.houseId = houseId;
		this.modelId = modelId;
		this.ownerName = ownerName;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
		this.skillListIds = skillListIds;
		this.guildshareParams = guildshareParams;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.houseId = reader.readInt();
		if (houseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on houseId = %s, it doesn't respect the following condition : houseId < 0", houseId));
		this.modelId = reader.readInt();
		if (modelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on modelId = %s, it doesn't respect the following condition : modelId < 0", modelId));
		this.ownerName = reader.readUTF();
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
		int length = reader.readUShort();
		this.skillListIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.skillListIds.add(entry);
		}
		this.guildshareParams = reader.readUInt();
		if (guildshareParams < 0 || guildshareParams > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on guildshareParams = %s, it doesn't respect the following condition : guildshareParams < 0 || guildshareParams > 4.294967295E9", guildshareParams));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.houseId);
		writer.writeInt(this.modelId);
		writer.writeUTF(this.ownerName);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
		writer.writeUShort(this.skillListIds.size());
		for (int entry : this.skillListIds)
		{
			writer.writeInt(entry);
		}
		writer.writeUInt(this.guildshareParams);
	}
}