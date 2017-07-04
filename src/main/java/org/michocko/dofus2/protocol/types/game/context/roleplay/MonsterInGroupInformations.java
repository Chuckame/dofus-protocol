package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.roleplay.MonsterInGroupLightInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class MonsterInGroupInformations extends MonsterInGroupLightInformations {
	public static final short TYPE_ID = 144;
	
	private EntityLook look;
	
	public MonsterInGroupInformations() {
	}
	
	public MonsterInGroupInformations(int creatureGenericId, byte grade, EntityLook look) {
		super(creatureGenericId, grade);
		this.look = look;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.look = new EntityLook();
		this.look.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.look.serialize(writer);
	}
}