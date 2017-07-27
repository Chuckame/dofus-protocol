package org.chuckame.dofus2.protocol.types.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.MapCoordinates;

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
	public short getProtocolTypeId() {
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