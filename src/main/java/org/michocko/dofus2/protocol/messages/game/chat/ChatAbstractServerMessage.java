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
public class ChatAbstractServerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 880;
	
	private byte channel;
	private String content;
	private int timestamp;
	private String fingerprint;
	
	public ChatAbstractServerMessage() {
	}
	
	public ChatAbstractServerMessage(byte channel, String content, int timestamp, String fingerprint) {
		this.channel = channel;
		this.content = content;
		this.timestamp = timestamp;
		this.fingerprint = fingerprint;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.channel = reader.readSByte();
		if (channel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on channel = %s, it doesn't respect the following condition : channel < 0", channel));
		this.content = reader.readUTF();
		this.timestamp = reader.readInt();
		if (timestamp < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on timestamp = %s, it doesn't respect the following condition : timestamp < 0", timestamp));
		this.fingerprint = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.channel);
		writer.writeUTF(this.content);
		writer.writeInt(this.timestamp);
		writer.writeUTF(this.fingerprint);
	}
}