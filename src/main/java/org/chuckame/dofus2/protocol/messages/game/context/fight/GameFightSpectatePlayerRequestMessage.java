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
public class GameFightSpectatePlayerRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6474;
	
	private int playerId;
	
	public GameFightSpectatePlayerRequestMessage() {
	}
	
	public GameFightSpectatePlayerRequestMessage(int playerId) {
		this.playerId = playerId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.playerId);
	}
}