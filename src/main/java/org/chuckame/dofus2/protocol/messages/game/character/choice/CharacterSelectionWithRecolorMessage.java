package org.chuckame.dofus2.protocol.messages.game.character.choice;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.character.choice.CharacterSelectionMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharacterSelectionWithRecolorMessage extends CharacterSelectionMessage {
	public static final int MESSAGE_ID = 6075;
	
	private Collection<Integer> indexedColor;
	
	public CharacterSelectionWithRecolorMessage() {
	}
	
	public CharacterSelectionWithRecolorMessage(int id, Collection<Integer> indexedColor) {
		super(id);
		this.indexedColor = indexedColor;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.indexedColor = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.indexedColor.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.indexedColor.size());
		for (int entry : this.indexedColor)
		{
			writer.writeInt(entry);
		}
	}
}