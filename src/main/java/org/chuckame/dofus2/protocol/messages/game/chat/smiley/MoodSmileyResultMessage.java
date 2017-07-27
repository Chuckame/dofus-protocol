package org.chuckame.dofus2.protocol.messages.game.chat.smiley;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MoodSmileyResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6196;
	
	private byte resultCode;
	private byte smileyId;
	
	public MoodSmileyResultMessage() {
	}
	
	public MoodSmileyResultMessage(byte resultCode, byte smileyId) {
		this.resultCode = resultCode;
		this.smileyId = smileyId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.resultCode = reader.readSByte();
		if (resultCode < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on resultCode = %s, it doesn't respect the following condition : resultCode < 0", resultCode));
		this.smileyId = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.resultCode);
		writer.writeSByte(this.smileyId);
	}
}