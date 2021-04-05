package org.michocko.dofus2.protocol.messages.game.character.choice;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicCharactersListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6475;
	
	private Collection<CharacterBaseInformations> characters;
	
	public BasicCharactersListMessage() {
	}
	
	public BasicCharactersListMessage(Collection<CharacterBaseInformations> characters) {
		this.characters = characters;
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
		int length = reader.readUShort();
		this.characters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterBaseInformations entry = (CharacterBaseInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.characters.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.characters.size());
		for (CharacterBaseInformations entry : this.characters)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}