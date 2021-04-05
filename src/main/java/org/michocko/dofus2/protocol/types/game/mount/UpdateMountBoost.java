package org.michocko.dofus2.protocol.types.game.mount;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class UpdateMountBoost implements INetworkType {
	public static final short TYPE_ID = 356;
	
	private byte type;
	
	public UpdateMountBoost() {
	}
	
	public UpdateMountBoost(byte type) {
		this.type = type;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.type = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.type);
	}
}