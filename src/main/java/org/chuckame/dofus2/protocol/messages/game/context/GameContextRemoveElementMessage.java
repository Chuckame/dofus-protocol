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
public class GameContextRemoveElementMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 251;
	
	private int id;
	
	public GameContextRemoveElementMessage() {
	}
	
	public GameContextRemoveElementMessage(int id) {
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