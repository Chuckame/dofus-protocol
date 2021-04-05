package org.michocko.dofus2.protocol.types.game.context;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class MapCoordinates implements INetworkType {
	public static final short TYPE_ID = 174;
	
	private short worldX;
	private short worldY;
	
	public MapCoordinates() {
	}
	
	public MapCoordinates(short worldX, short worldY) {
		this.worldX = worldX;
		this.worldY = worldY;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
	}
}