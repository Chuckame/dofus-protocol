package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class ObjectItemInRolePlay implements INetworkType {
	public static final short TYPE_ID = 198;
	
	private short cellId;
	private short objectGID;
	
	public ObjectItemInRolePlay() {
	}
	
	public ObjectItemInRolePlay(short cellId, short objectGID) {
		this.cellId = cellId;
		this.objectGID = objectGID;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.cellId = reader.readShort();
		if (cellId < 0 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < 0 || cellId > 559", cellId));
		this.objectGID = reader.readShort();
		if (objectGID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGID = %s, it doesn't respect the following condition : objectGID < 0", objectGID));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.cellId);
		writer.writeShort(this.objectGID);
	}
}