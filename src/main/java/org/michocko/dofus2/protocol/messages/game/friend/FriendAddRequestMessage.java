package org.michocko.dofus2.protocol.messages.game.friend;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class FriendAddRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 4004;
	
	private String name;
	
	public FriendAddRequestMessage() {
	}
	
	public FriendAddRequestMessage(String name) {
		this.name = name;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.name = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.name);
	}
}