package org.michocko.dofus2.protocol.types.game.character.choice;

import org.michocko.dofus2.protocol.types.game.character.AbstractCharacterInformation;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterToRelookInformation extends AbstractCharacterInformation {
	public static final short TYPE_ID = 399;
	
	private int cosmeticId;
	
	public CharacterToRelookInformation() {
	}
	
	public CharacterToRelookInformation(int id, int cosmeticId) {
		super(id);
		this.cosmeticId = cosmeticId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.cosmeticId = reader.readInt();
		if (cosmeticId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on cosmeticId = %s, it doesn't respect the following condition : cosmeticId < 0", cosmeticId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.cosmeticId);
	}
}