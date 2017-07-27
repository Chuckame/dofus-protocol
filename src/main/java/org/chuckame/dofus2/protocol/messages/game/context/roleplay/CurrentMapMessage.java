package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CurrentMapMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 220;
	
	private int mapId;
	private String mapKey;
	
	public CurrentMapMessage() {
	}
	
	public CurrentMapMessage(int mapId, String mapKey) {
		this.mapId = mapId;
		this.mapKey = mapKey;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mapId = reader.readInt();
		if (mapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mapId = %s, it doesn't respect the following condition : mapId < 0", mapId));
		this.mapKey = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.mapId);
		writer.writeUTF(this.mapKey);
	}
}