package org.michocko.dofus2.protocol.messages.game.chat;

import org.michocko.dofus2.protocol.messages.game.chat.ChatAbstractServerMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ChatServerMessage extends ChatAbstractServerMessage {
	public static final int MESSAGE_ID = 881;
	
	private int senderId;
	private String senderName;
	private int senderAccountId;
	
	public ChatServerMessage() {
	}
	
	public ChatServerMessage(byte channel, String content, int timestamp, String fingerprint, int senderId, String senderName, int senderAccountId) {
		super(channel, content, timestamp, fingerprint);
		this.senderId = senderId;
		this.senderName = senderName;
		this.senderAccountId = senderAccountId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.senderId = reader.readInt();
		this.senderName = reader.readUTF();
		this.senderAccountId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.senderId);
		writer.writeUTF(this.senderName);
		writer.writeInt(this.senderAccountId);
	}
}