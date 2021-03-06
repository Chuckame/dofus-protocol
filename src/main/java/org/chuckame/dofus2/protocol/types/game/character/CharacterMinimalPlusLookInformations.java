package org.chuckame.dofus2.protocol.types.game.character;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.character.CharacterMinimalInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterMinimalPlusLookInformations extends CharacterMinimalInformations {
	public static final short TYPE_ID = 163;
	
	private EntityLook entityLook;
	
	public CharacterMinimalPlusLookInformations() {
	}
	
	public CharacterMinimalPlusLookInformations(int id, short level, String name, EntityLook entityLook) {
		super(id, level, name);
		this.entityLook = entityLook;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.entityLook = new EntityLook();
		this.entityLook.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.entityLook.serialize(writer);
	}
}