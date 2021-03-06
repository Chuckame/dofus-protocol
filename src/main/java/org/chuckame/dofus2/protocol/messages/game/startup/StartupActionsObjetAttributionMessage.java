package org.chuckame.dofus2.protocol.messages.game.startup;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StartupActionsObjetAttributionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1303;
	
	private int actionId;
	private int characterId;
	
	public StartupActionsObjetAttributionMessage() {
	}
	
	public StartupActionsObjetAttributionMessage(int actionId, int characterId) {
		this.actionId = actionId;
		this.characterId = characterId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.actionId = reader.readInt();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.actionId);
		writer.writeInt(this.characterId);
	}
}