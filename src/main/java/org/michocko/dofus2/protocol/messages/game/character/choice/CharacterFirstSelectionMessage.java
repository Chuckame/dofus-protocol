package org.michocko.dofus2.protocol.messages.game.character.choice;

import org.michocko.dofus2.protocol.messages.game.character.choice.CharacterSelectionMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
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