package org.michocko.dofus2.protocol.types.game.context;

import org.michocko.dofus2.protocol.types.game.context.MapCoordinates;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class MapCoordinatesAndId extends MapCoordinates {
	public static final short TYPE_ID = 392;
	
	private int mapId;
	
	public MapCoordinatesAndId() {
	}
	
	public MapCoordinatesAndId(short worldX, short worldY, int mapId) {
		super(worldX, worldY);
		this.mapId = mapId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.mapId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.mapId);
	}
}