package org.chuckame.dofus2.protocol.types.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.MapCoordinatesAndId;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class MapCoordinatesExtended extends MapCoordinatesAndId {
	public static final short TYPE_ID = 176;
	
	private short subAreaId;
	
	public MapCoordinatesExtended() {
	}
	
	public MapCoordinatesExtended(short worldX, short worldY, int mapId, short subAreaId) {
		super(worldX, worldY, mapId);
		this.subAreaId = subAreaId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.subAreaId);
	}
}