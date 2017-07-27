package org.chuckame.dofus2.protocol.messages.game.chat;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.content = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.content);
	}
}