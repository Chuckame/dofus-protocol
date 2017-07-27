package org.chuckame.dofus2.protocol.messages.game.friend;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class FriendWarnOnConnectionStateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5630;
	
	private boolean enable;
	
	public FriendWarnOnConnectionStateMessage() {
	}
	
	public FriendWarnOnConnectionStateMessage(boolean enable) {
		this.enable = enable;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.enable = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enable);
	}
}