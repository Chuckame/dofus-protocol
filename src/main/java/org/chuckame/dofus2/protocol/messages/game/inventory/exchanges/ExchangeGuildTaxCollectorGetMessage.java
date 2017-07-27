package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItemQuantity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeGuildTaxCollectorGetMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5762;
	
	private String collectorName;
	private short worldX;
	private short worldY;
	private int mapId;
	private short subAreaId;
	private String userName;
	private double experience;
	private Collection<ObjectItemQuantity> objectsInfos;
	
	public ExchangeGuildTaxCollectorGetMessage() {
	}
	
	public ExchangeGuildTaxCollectorGetMessage(String collectorName, short worldX, short worldY, int mapId, short subAreaId, String userName, double experience, Collection<ObjectItemQuantity> objectsInfos) {
		this.collectorName = collectorName;
		this.worldX = worldX;
		this.worldY = worldY;
		this.mapId = mapId;
		this.subAreaId = subAreaId;
		this.userName = userName;
		this.experience = experience;
		this.objectsInfos = objectsInfos;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.collectorName = reader.readUTF();
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
		this.userName = reader.readUTF();
		this.experience = reader.readDouble();
		int length = reader.readUShort();
		this.objectsInfos = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemQuantity entry = new ObjectItemQuantity();
			entry.deserialize(reader);
			this.objectsInfos.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.collectorName);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
		writer.writeInt(this.mapId);
		writer.writeShort(this.subAreaId);
		writer.writeUTF(this.userName);
		writer.writeDouble(this.experience);
		writer.writeUShort(this.objectsInfos.size());
		for (ObjectItemQuantity entry : this.objectsInfos)
		{
			entry.serialize(writer);
		}
	}
}