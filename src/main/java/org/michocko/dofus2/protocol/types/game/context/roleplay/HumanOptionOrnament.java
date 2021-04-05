package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.context.roleplay.HumanOption;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class HumanOptionOrnament extends HumanOption {
	public static final short TYPE_ID = 411;
	
	private short ornamentId;
	
	public HumanOptionOrnament() {
	}
	
	public HumanOptionOrnament(short ornamentId) {
		this.ornamentId = ornamentId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.ornamentId = reader.readShort();
		if (ornamentId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on ornamentId = %s, it doesn't respect the following condition : ornamentId < 0", ornamentId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.ornamentId);
	}
}