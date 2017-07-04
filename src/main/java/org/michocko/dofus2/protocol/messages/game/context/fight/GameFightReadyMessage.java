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
public class GameFightReadyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 708;
	
	private boolean isReady;
	
	public GameFightReadyMessage() {
	}
	
	public GameFightReadyMessage(boolean isReady) {
		this.isReady = isReady;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.isReady = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.isReady);
	}
}