package org.michocko.dofus2.protocol.types.game.actions.fight;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameActionMarkedCell implements INetworkType {
	public static final short TYPE_ID = 85;
	
	private short cellId;
	private byte zoneSize;
	private int cellColor;
	private byte cellsType;
	
	public GameActionMarkedCell() {
	}
	
	public GameActionMarkedCell(short cellId, byte zoneSize, int cellColor, byte cellsType) {
		this.cellId = cellId;
		this.zoneSize = zoneSize;
		this.cellColor = cellColor;
		this.cellsType = cellsType;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.cellId = reader.readShort();
		if (cellId < 0 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < 0 || cellId > 559", cellId));
		this.zoneSize = reader.readSByte();
		this.cellColor = reader.readInt();
		this.cellsType = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.cellId);
		writer.writeSByte(this.zoneSize);
		writer.writeInt(this.cellColor);
		writer.writeSByte(this.cellsType);
	}
}