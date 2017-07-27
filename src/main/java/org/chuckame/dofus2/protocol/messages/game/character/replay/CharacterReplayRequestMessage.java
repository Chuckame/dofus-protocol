package org.chuckame.dofus2.protocol.messages.game.character.replay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CharacterReplayRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 167;
	
	private int characterId;
	
	public CharacterReplayRequestMessage() {
	}
	
	public CharacterReplayRequestMessage(int characterId) {
		this.characterId = characterId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.characterId);
	}
}