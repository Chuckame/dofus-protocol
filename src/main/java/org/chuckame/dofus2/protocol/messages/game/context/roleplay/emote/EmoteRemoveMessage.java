package org.chuckame.dofus2.protocol.messages.game.context.roleplay.emote;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class EmoteRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5687;
	
	private short emoteId;
	
	public EmoteRemoveMessage() {
	}
	
	public EmoteRemoveMessage(short emoteId) {
		this.emoteId = emoteId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.emoteId = reader.readByte();
		if (emoteId < 0 || emoteId > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on emoteId = %s, it doesn't respect the following condition : emoteId < 0 || emoteId > 255", emoteId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.emoteId);
	}
}