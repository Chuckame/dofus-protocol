package org.chuckame.dofus2.protocol.messages.game.character.choice;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.messages.game.character.choice.BasicCharactersListMessage;
import org.chuckame.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharactersListMessage extends BasicCharactersListMessage {
	public static final int MESSAGE_ID = 151;
	
	private boolean hasStartupActions;
	
	public CharactersListMessage() {
	}
	
	public CharactersListMessage(Collection<CharacterBaseInformations> characters, boolean hasStartupActions) {
		super(characters);
		this.hasStartupActions = hasStartupActions;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.hasStartupActions = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.hasStartupActions);
	}
}