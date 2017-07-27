package org.chuckame.dofus2.protocol.types.game.character;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.character.AbstractCharacterInformation;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterMinimalInformations extends AbstractCharacterInformation {
	public static final short TYPE_ID = 110;
	
	private short level;
	private String name;
	
	public CharacterMinimalInformations() {
	}
	
	public CharacterMinimalInformations(int id, short level, String name) {
		super(id);
		this.level = level;
		this.name = name;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.level = reader.readByte();
		if (level < 1 || level > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 1 || level > 200", level));
		this.name = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.level);
		writer.writeUTF(this.name);
	}
}