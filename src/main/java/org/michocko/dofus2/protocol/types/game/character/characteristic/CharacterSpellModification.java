package org.michocko.dofus2.protocol.types.game.character.characteristic;

import org.michocko.dofus2.protocol.types.game.character.characteristic.CharacterBaseCharacteristic;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class CharacterSpellModification implements INetworkType {
	public static final short TYPE_ID = 215;
	
	private byte modificationType;
	private short spellId;
	private CharacterBaseCharacteristic value;
	
	public CharacterSpellModification() {
	}
	
	public CharacterSpellModification(byte modificationType, short spellId, CharacterBaseCharacteristic value) {
		this.modificationType = modificationType;
		this.spellId = spellId;
		this.value = value;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.modificationType = reader.readSByte();
		if (modificationType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on modificationType = %s, it doesn't respect the following condition : modificationType < 0", modificationType));
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.value = new CharacterBaseCharacteristic();
		this.value.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.modificationType);
		writer.writeShort(this.spellId);
		this.value.serialize(writer);
	}
}