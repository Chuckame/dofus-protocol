package org.michocko.dofus2.protocol.messages.game.character.choice;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.character.choice.CharacterToRecolorInformation;
import org.michocko.dofus2.protocol.types.game.character.choice.CharacterToRelookInformation;
import org.michocko.dofus2.protocol.types.game.character.choice.CharacterBaseInformations;
import org.michocko.dofus2.protocol.messages.game.character.choice.CharactersListMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharactersListWithModificationsMessage extends CharactersListMessage {
	public static final int MESSAGE_ID = 6120;
	
	private Collection<CharacterToRecolorInformation> charactersToRecolor;
	private Collection<Integer> charactersToRename;
	private Collection<Integer> unusableCharacters;
	private Collection<CharacterToRelookInformation> charactersToRelook;
	
	public CharactersListWithModificationsMessage() {
	}
	
	public CharactersListWithModificationsMessage(Collection<CharacterBaseInformations> characters, boolean hasStartupActions, Collection<CharacterToRecolorInformation> charactersToRecolor, Collection<Integer> charactersToRename, Collection<Integer> unusableCharacters, Collection<CharacterToRelookInformation> charactersToRelook) {
		super(characters, hasStartupActions);
		this.charactersToRecolor = charactersToRecolor;
		this.charactersToRename = charactersToRename;
		this.unusableCharacters = unusableCharacters;
		this.charactersToRelook = charactersToRelook;
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
		int length = reader.readUShort();
		this.charactersToRecolor = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterToRecolorInformation entry = new CharacterToRecolorInformation();
			entry.deserialize(reader);
			this.charactersToRecolor.add(entry);
		}
		length = reader.readUShort();
		this.charactersToRename = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.charactersToRename.add(entry);
		}
		length = reader.readUShort();
		this.unusableCharacters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.unusableCharacters.add(entry);
		}
		length = reader.readUShort();
		this.charactersToRelook = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			CharacterToRelookInformation entry = new CharacterToRelookInformation();
			entry.deserialize(reader);
			this.charactersToRelook.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.charactersToRecolor.size());
		for (CharacterToRecolorInformation entry : this.charactersToRecolor)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.charactersToRename.size());
		for (int entry : this.charactersToRename)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.unusableCharacters.size());
		for (int entry : this.unusableCharacters)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.charactersToRelook.size());
		for (CharacterToRelookInformation entry : this.charactersToRelook)
		{
			entry.serialize(writer);
		}
	}
}