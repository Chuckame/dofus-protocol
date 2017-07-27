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
public class HouseInformations implements INetworkType {
	public static final short TYPE_ID = 111;
	
	private int houseId;
	private Collection<Integer> doorsOnMap;
	private String ownerName;
	private short modelId;
	
	public HouseInformations() {
	}
	
	public HouseInformations(int houseId, Collection<Integer> doorsOnMap, String ownerName, short modelId) {
		this.houseId = houseId;
		this.doorsOnMap = doorsOnMap;
		this.ownerName = ownerName;
		this.modelId = modelId;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.houseId = reader.readInt();
		if (houseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on houseId = %s, it doesn't respect the following condition : houseId < 0", houseId));
		int length = reader.readUShort();
		this.doorsOnMap = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.doorsOnMap.add(entry);
		}
		this.ownerName = reader.readUTF();
		this.modelId = reader.readShort();
		if (modelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on modelId = %s, it doesn't respect the following condition : modelId < 0", modelId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.houseId);
		writer.writeUShort(this.doorsOnMap.size());
		for (int entry : this.doorsOnMap)
		{
			writer.writeInt(entry);
		}
		writer.writeUTF(this.ownerName);
		writer.writeShort(this.modelId);
	}
}