package org.michocko.dofus2.protocol.messages.game.chat.smiley;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.smileyId = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.smileyId);
	}
}