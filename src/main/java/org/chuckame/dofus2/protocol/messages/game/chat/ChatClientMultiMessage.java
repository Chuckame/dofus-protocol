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
public class ChatClientMultiMessage extends ChatAbstractClientMessage {
	public static final int MESSAGE_ID = 861;
	
	private byte channel;
	
	public ChatClientMultiMessage() {
	}
	
	public ChatClientMultiMessage(String content, byte channel) {
		super(content);
		this.channel = channel;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.channel = reader.readSByte();
		if (channel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on channel = %s, it doesn't respect the following condition : channel < 0", channel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.channel);
	}
}