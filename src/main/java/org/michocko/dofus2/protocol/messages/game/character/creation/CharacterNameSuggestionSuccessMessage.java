package org.michocko.dofus2.protocol.messages.game.character.creation;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterNameSuggestionSuccessMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5544;
	
	private String suggestion;
	
	public CharacterNameSuggestionSuccessMessage() {
	}
	
	public CharacterNameSuggestionSuccessMessage(String suggestion) {
		this.suggestion = suggestion;
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
		this.suggestion = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.suggestion);
	}
}