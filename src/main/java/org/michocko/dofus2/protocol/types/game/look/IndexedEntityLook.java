package org.michocko.dofus2.protocol.types.game.look;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class IndexedEntityLook implements INetworkType {
	public static final short TYPE_ID = 405;
	
	private EntityLook look;
	private byte index;
	
	public IndexedEntityLook() {
	}
	
	public IndexedEntityLook(EntityLook look, byte index) {
		this.look = look;
		this.index = index;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.look = new EntityLook();
		this.look.deserialize(reader);
		this.index = reader.readSByte();
		if (index < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on index = %s, it doesn't respect the following condition : index < 0", index));
	}
	
	public void serialize(IDataWriter writer) {
		this.look.serialize(writer);
		writer.writeSByte(this.index);
	}
}