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
public class GameContextKickMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6081;
	
	private int targetId;
	
	public GameContextKickMessage() {
	}
	
	public GameContextKickMessage(int targetId) {
		this.targetId = targetId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.targetId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.targetId);
	}
}