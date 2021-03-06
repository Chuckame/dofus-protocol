package org.chuckame.dofus2.protocol.messages.game.character.deletion;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterDeletionRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 165;
	
	private int characterId;
	private String secretAnswerHash;
	
	public CharacterDeletionRequestMessage() {
	}
	
	public CharacterDeletionRequestMessage(int characterId, String secretAnswerHash) {
		this.characterId = characterId;
		this.secretAnswerHash = secretAnswerHash;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
		this.secretAnswerHash = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.characterId);
		writer.writeUTF(this.secretAnswerHash);
	}
}