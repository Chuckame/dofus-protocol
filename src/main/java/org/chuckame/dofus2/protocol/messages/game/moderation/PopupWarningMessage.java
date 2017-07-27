package org.chuckame.dofus2.protocol.messages.game.moderation;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PopupWarningMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6134;
	
	private short lockDuration;
	private String author;
	private String content;
	
	public PopupWarningMessage() {
	}
	
	public PopupWarningMessage(short lockDuration, String author, String content) {
		this.lockDuration = lockDuration;
		this.author = author;
		this.content = content;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.lockDuration = reader.readByte();
		if (lockDuration < 0 || lockDuration > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on lockDuration = %s, it doesn't respect the following condition : lockDuration < 0 || lockDuration > 255", lockDuration));
		this.author = reader.readUTF();
		this.content = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.lockDuration);
		writer.writeUTF(this.author);
		writer.writeUTF(this.content);
	}
}