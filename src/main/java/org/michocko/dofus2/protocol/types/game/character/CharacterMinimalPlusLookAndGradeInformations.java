package org.michocko.dofus2.protocol.types.game.character;

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
public class CharacterMinimalPlusLookAndGradeInformations extends CharacterMinimalPlusLookInformations {
	public static final short TYPE_ID = 193;
	
	private int grade;
	
	public CharacterMinimalPlusLookAndGradeInformations() {
	}
	
	public CharacterMinimalPlusLookAndGradeInformations(int id, short level, String name, EntityLook entityLook, int grade) {
		super(id, level, name, entityLook);
		this.grade = grade;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.grade = reader.readInt();
		if (grade < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on grade = %s, it doesn't respect the following condition : grade < 0", grade));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.grade);
	}
}