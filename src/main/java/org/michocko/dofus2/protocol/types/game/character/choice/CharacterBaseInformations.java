package org.michocko.dofus2.protocol.types.game.character.choice;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.character.CharacterMinimalPlusLookInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterBaseInformations extends CharacterMinimalPlusLookInformations {
	public static final short TYPE_ID = 45;
	
	private byte breed;
	private boolean sex;
	
	public CharacterBaseInformations() {
	}
	
	public CharacterBaseInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex) {
		super(id, level, name, entityLook);
		this.breed = breed;
		this.sex = sex;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.breed = reader.readSByte();
		this.sex = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.breed);
		writer.writeBoolean(this.sex);
	}
}