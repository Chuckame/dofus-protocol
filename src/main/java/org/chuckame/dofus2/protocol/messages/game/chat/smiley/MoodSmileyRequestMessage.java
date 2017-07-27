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
public class MoodSmileyRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6192;
	
	private byte smileyId;
	
	public MoodSmileyRequestMessage() {
	}
	
	public MoodSmileyRequestMessage(byte smileyId) {
		this.smileyId = smileyId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.smileyId = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.smileyId);
	}
}