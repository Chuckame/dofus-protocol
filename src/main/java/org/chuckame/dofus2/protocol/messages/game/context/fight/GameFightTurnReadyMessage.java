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
public class GameFightTurnReadyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 716;
	
	private boolean isReady;
	
	public GameFightTurnReadyMessage() {
	}
	
	public GameFightTurnReadyMessage(boolean isReady) {
		this.isReady = isReady;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.isReady = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.isReady);
	}
}