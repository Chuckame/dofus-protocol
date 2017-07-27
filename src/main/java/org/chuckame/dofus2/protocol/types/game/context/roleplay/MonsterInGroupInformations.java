package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.MonsterInGroupLightInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

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
	public short getProtocolTypeId() {
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