package org.chuckame.dofus2.protocol.messages.game.character.choice;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.character.choice.CharacterSelectionMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharacterFirstSelectionMessage extends CharacterSelectionMessage {
	public static final int MESSAGE_ID = 6084;
	
	private boolean doTutorial;
	
	public CharacterFirstSelectionMessage() {
	}
	
	public CharacterFirstSelectionMessage(int id, boolean doTutorial) {
		super(id);
		this.doTutorial = doTutorial;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.doTutorial = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.doTutorial);
	}
}