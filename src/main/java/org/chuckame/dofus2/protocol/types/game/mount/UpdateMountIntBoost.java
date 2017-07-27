package org.chuckame.dofus2.protocol.types.game.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.mount.UpdateMountBoost;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class UpdateMountIntBoost extends UpdateMountBoost {
	public static final short TYPE_ID = 357;
	
	private int value;
	
	public UpdateMountIntBoost() {
	}
	
	public UpdateMountIntBoost(byte type, int value) {
		super(type);
		this.value = value;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.value = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.value);
	}
}