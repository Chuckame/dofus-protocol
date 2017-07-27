package org.chuckame.dofus2.protocol.types.game.look;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class SubEntity implements INetworkType {
	public static final short TYPE_ID = 54;
	
	private byte bindingPointCategory;
	private byte bindingPointIndex;
	private EntityLook subEntityLook;
	
	public SubEntity() {
	}
	
	public SubEntity(byte bindingPointCategory, byte bindingPointIndex, EntityLook subEntityLook) {
		this.bindingPointCategory = bindingPointCategory;
		this.bindingPointIndex = bindingPointIndex;
		this.subEntityLook = subEntityLook;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.bindingPointCategory = reader.readSByte();
		if (bindingPointCategory < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on bindingPointCategory = %s, it doesn't respect the following condition : bindingPointCategory < 0", bindingPointCategory));
		this.bindingPointIndex = reader.readSByte();
		if (bindingPointIndex < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on bindingPointIndex = %s, it doesn't respect the following condition : bindingPointIndex < 0", bindingPointIndex));
		this.subEntityLook = new EntityLook();
		this.subEntityLook.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.bindingPointCategory);
		writer.writeSByte(this.bindingPointIndex);
		this.subEntityLook.serialize(writer);
	}
}