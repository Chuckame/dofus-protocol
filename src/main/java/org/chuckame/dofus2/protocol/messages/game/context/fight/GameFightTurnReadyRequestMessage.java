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
public class GameFightTurnReadyRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 715;
	
	private int id;
	
	public GameFightTurnReadyRequestMessage() {
	}
	
	public GameFightTurnReadyRequestMessage(int id) {
		this.id = id;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
	}
}