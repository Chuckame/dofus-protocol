package org.chuckame.dofus2.protocol.messages.game.chat.report;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChatMessageReportMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 821;
	
	private String senderName;
	private String content;
	private int timestamp;
	private byte channel;
	private String fingerprint;
	private byte reason;
	
	public ChatMessageReportMessage() {
	}
	
	public ChatMessageReportMessage(String senderName, String content, int timestamp, byte channel, String fingerprint, byte reason) {
		this.senderName = senderName;
		this.content = content;
		this.timestamp = timestamp;
		this.channel = channel;
		this.fingerprint = fingerprint;
		this.reason = reason;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.senderName = reader.readUTF();
		this.content = reader.readUTF();
		this.timestamp = reader.readInt();
		if (timestamp < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on timestamp = %s, it doesn't respect the following condition : timestamp < 0", timestamp));
		this.channel = reader.readSByte();
		if (channel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on channel = %s, it doesn't respect the following condition : channel < 0", channel));
		this.fingerprint = reader.readUTF();
		this.reason = reader.readSByte();
		if (reason < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on reason = %s, it doesn't respect the following condition : reason < 0", reason));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.senderName);
		writer.writeUTF(this.content);
		writer.writeInt(this.timestamp);
		writer.writeSByte(this.channel);
		writer.writeUTF(this.fingerprint);
		writer.writeSByte(this.reason);
	}
}