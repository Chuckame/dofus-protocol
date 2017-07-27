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
public class FriendDeleteResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5601;
	
	private boolean success;
	private String name;
	
	public FriendDeleteResultMessage() {
	}
	
	public FriendDeleteResultMessage(boolean success, String name) {
		this.success = success;
		this.name = name;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.success = reader.readBoolean();
		this.name = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.success);
		writer.writeUTF(this.name);
	}
}