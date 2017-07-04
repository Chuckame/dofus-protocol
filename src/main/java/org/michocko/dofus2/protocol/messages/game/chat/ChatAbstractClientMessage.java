package org.michocko.dofus2.protocol.messages.game.chat;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChatAbstractClientMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 850;
	
	private String content;
	
	public ChatAbstractClientMessage() {
	}
	
	public ChatAbstractClientMessage(String content) {
		this.content = content;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.content = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.content);
	}
}