package org.chuckame.dofus2.protocol.messages.game.chat;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.chat.ChatAbstractClientMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ChatClientPrivateMessage extends ChatAbstractClientMessage {
	public static final int MESSAGE_ID = 851;
	
	private String receiver;
	
	public ChatClientPrivateMessage() {
	}
	
	public ChatClientPrivateMessage(String content, String receiver) {
		super(content);
		this.receiver = receiver;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.receiver = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.receiver);
	}
}