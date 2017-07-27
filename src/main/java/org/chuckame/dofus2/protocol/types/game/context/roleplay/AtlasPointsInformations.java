package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.context.MapCoordinatesExtended;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AtlasPointsInformations implements INetworkType {
	public static final short TYPE_ID = 175;
	
	private byte type;
	private Collection<MapCoordinatesExtended> coords;
	
	public AtlasPointsInformations() {
	}
	
	public AtlasPointsInformations(byte type, Collection<MapCoordinatesExtended> coords) {
		this.type = type;
		this.coords = coords;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.type = reader.readSByte();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
		int length = reader.readUShort();
		this.coords = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MapCoordinatesExtended entry = new MapCoordinatesExtended();
			entry.deserialize(reader);
			this.coords.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.type);
		writer.writeUShort(this.coords.size());
		for (MapCoordinatesExtended entry : this.coords)
		{
			entry.serialize(writer);
		}
	}
}