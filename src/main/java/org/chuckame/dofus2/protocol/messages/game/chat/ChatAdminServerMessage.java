package org.chuckame.dofus2.protocol.messages.game.chat;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.chat.ChatServerMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ChatAdminServerMessage extends ChatServerMessage {
	public static final int MESSAGE_ID = 6135;
	
	
	public ChatAdminServerMessage() {
	}
	
	public ChatAdminServerMessage(byte channel, String content, int timestamp, String fingerprint, int senderId, String senderName, int senderAccountId) {
		super(channel, content, timestamp, fingerprint, senderId, senderName, senderAccountId);
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}