package org.michocko.dofus2.protocol.types.game.interactive;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class MapObstacle implements INetworkType {
	public static final short TYPE_ID = 200;
	
	private short obstacleCellId;
	private byte state;
	
	public MapObstacle() {
	}
	
	public MapObstacle(short obstacleCellId, byte state) {
		this.obstacleCellId = obstacleCellId;
		this.state = state;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.obstacleCellId = reader.readShort();
		if (obstacleCellId < 0 || obstacleCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on obstacleCellId = %s, it doesn't respect the following condition : obstacleCellId < 0 || obstacleCellId > 559", obstacleCellId));
		this.state = reader.readSByte();
		if (state < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on state = %s, it doesn't respect the following condition : state < 0", state));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.obstacleCellId);
		writer.writeSByte(this.state);
	}
}