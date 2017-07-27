package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameContextReadyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6071;
	
	private int mapId;
	
	public GameContextReadyMessage() {
	}
	
	public GameContextReadyMessage(int mapId) {
		this.mapId = mapId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mapId = reader.readInt();
		if (mapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mapId = %s, it doesn't respect the following condition : mapId < 0", mapId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapId);
	}
}