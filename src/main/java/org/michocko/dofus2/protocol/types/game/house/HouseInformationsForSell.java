package org.michocko.dofus2.protocol.types.game.house;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class HouseInformationsForSell implements INetworkType {
	public static final short TYPE_ID = 221;
	
	private int modelId;
	private String ownerName;
	private boolean ownerConnected;
	private short worldX;
	private short worldY;
	private short subAreaId;
	private byte nbRoom;
	private byte nbChest;
	private Collection<Integer> skillListIds;
	private boolean isLocked;
	private int price;
	
	public HouseInformationsForSell() {
	}
	
	public HouseInformationsForSell(int modelId, String ownerName, boolean ownerConnected, short worldX, short worldY, short subAreaId, byte nbRoom, byte nbChest, Collection<Integer> skillListIds, boolean isLocked, int price) {
		this.modelId = modelId;
		this.ownerName = ownerName;
		this.ownerConnected = ownerConnected;
		this.worldX = worldX;
		this.worldY = worldY;
		this.subAreaId = subAreaId;
		this.nbRoom = nbRoom;
		this.nbChest = nbChest;
		this.skillListIds = skillListIds;
		this.isLocked = isLocked;
		this.price = price;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.modelId = reader.readInt();
		if (modelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on modelId = %s, it doesn't respect the following condition : modelId < 0", modelId));
		this.ownerName = reader.readUTF();
		this.ownerConnected = reader.readBoolean();
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.nbRoom = reader.readSByte();
		this.nbChest = reader.readSByte();
		int length = reader.readUShort();
		this.skillListIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.skillListIds.add(entry);
		}
		this.isLocked = reader.readBoolean();
		this.price = reader.readInt();
		if (price < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0", price));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.modelId);
		writer.writeUTF(this.ownerName);
		writer.writeBoolean(this.ownerConnected);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeShort(this.subAreaId);
		writer.writeSByte(this.nbRoom);
		writer.writeSByte(this.nbChest);
		writer.writeUShort(this.skillListIds.size());
		for (int entry : this.skillListIds)
		{
			writer.writeInt(entry);
		}
		writer.writeBoolean(this.isLocked);
		writer.writeInt(this.price);
	}
}