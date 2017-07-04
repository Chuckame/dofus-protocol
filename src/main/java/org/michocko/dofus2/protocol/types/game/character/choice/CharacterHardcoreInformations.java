package org.michocko.dofus2.protocol.types.game.character.choice;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterHardcoreInformations extends CharacterBaseInformations {
	public static final short TYPE_ID = 86;
	
	private byte deathState;
	private short deathCount;
	private short deathMaxLevel;
	
	public CharacterHardcoreInformations() {
	}
	
	public CharacterHardcoreInformations(int id, short level, String name, EntityLook entityLook, byte breed, boolean sex, byte deathState, short deathCount, short deathMaxLevel) {
		super(id, level, name, entityLook, breed, sex);
		this.deathState = deathState;
		this.deathCount = deathCount;
		this.deathMaxLevel = deathMaxLevel;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.deathState = reader.readSByte();
		if (deathState < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on deathState = %s, it doesn't respect the following condition : deathState < 0", deathState));
		this.deathCount = reader.readShort();
		if (deathCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on deathCount = %s, it doesn't respect the following condition : deathCount < 0", deathCount));
		this.deathMaxLevel = reader.readByte();
		if (deathMaxLevel < 1 || deathMaxLevel > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on deathMaxLevel = %s, it doesn't respect the following condition : deathMaxLevel < 1 || deathMaxLevel > 200", deathMaxLevel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.deathState);
		writer.writeShort(this.deathCount);
		writer.writeByte(this.deathMaxLevel);
	}
}