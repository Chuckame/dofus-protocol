package org.michocko.dofus2.protocol.messages.game.context.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.characterId = reader.readInt();
		if (characterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on characterId = %s, it doesn't respect the following condition : characterId < 0", characterId));
		this.isReady = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.characterId);
		writer.writeBoolean(this.isReady);
	}
}