package org.chuckame.dofus2.protocol.messages.game.chat;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.chat.ChatAbstractServerMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ChatServerCopyMessage extends ChatAbstractServerMessage {
	public static final int MESSAGE_ID = 882;
	
	private int receiverId;
	private String receiverName;
	
	public ChatServerCopyMessage() {
	}
	
	public ChatServerCopyMessage(byte channel, String content, int timestamp, String fingerprint, int receiverId, String receiverName) {
		super(channel, content, timestamp, fingerprint);
		this.receiverId = receiverId;
		this.receiverName = receiverName;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.receiverId = reader.readInt();
		if (receiverId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on receiverId = %s, it doesn't respect the following condition : receiverId < 0", receiverId));
		this.receiverName = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.receiverId);
		writer.writeUTF(this.receiverName);
	}
}