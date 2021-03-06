package org.chuckame.dofus2.protocol.messages.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightHumanReadyStateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 740;
	
	private int characterId;
	private boolean isReady;
	
	public GameFightHumanReadyStateMessage() {
	}
	
	public GameFightHumanReadyStateMessage(int characterId, boolean isReady) {
		this.characterId = characterId;
		this.isReady = isReady;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
		this.isReady = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.characterId);
		writer.writeBoolean(this.isReady);
	}
}