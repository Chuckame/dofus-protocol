package org.chuckame.dofus2.protocol.messages.game.character.replay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.character.replay.CharacterReplayRequestMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class CharacterReplayWithRenameRequestMessage extends CharacterReplayRequestMessage {
	public static final int MESSAGE_ID = 6122;
	
	private String name;
	
	public CharacterReplayWithRenameRequestMessage() {
	}
	
	public CharacterReplayWithRenameRequestMessage(int characterId, String name) {
		super(characterId);
		this.name = name;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.name = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.name);
	}
}