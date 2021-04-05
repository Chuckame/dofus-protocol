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
public class EntityDispositionInformations implements INetworkType {
	public static final short TYPE_ID = 60;
	
	private short cellId;
	private byte direction;
	
	public EntityDispositionInformations() {
	}
	
	public EntityDispositionInformations(short cellId, byte direction) {
		this.cellId = cellId;
		this.direction = direction;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.cellId = reader.readShort();
		if (cellId < -1 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < -1 || cellId > 559", cellId));
		this.direction = reader.readSByte();
		if (direction < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on direction = %s, it doesn't respect the following condition : direction < 0", direction));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.cellId);
		writer.writeSByte(this.direction);
	}
}