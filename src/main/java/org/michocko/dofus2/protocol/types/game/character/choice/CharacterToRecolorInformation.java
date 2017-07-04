package org.michocko.dofus2.protocol.types.game.character.choice;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.character.AbstractCharacterInformation;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class CharacterToRecolorInformation extends AbstractCharacterInformation {
	public static final short TYPE_ID = 212;
	
	private Collection<Integer> colors;
	
	public CharacterToRecolorInformation() {
	}
	
	public CharacterToRecolorInformation(int id, Collection<Integer> colors) {
		super(id);
		this.colors = colors;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.colors = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.colors.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.colors.size());
		for (int entry : this.colors)
		{
			writer.writeInt(entry);
		}
	}
}