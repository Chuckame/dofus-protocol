package org.michocko.dofus2.protocol.messages.game.context.roleplay.emote;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class EmotePlayErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5688;
	
	private short emoteId;
	
	public EmotePlayErrorMessage() {
	}
	
	public EmotePlayErrorMessage(short emoteId) {
		this.emoteId = emoteId;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.emoteId = reader.readByte();
		if (emoteId < 0 || emoteId > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on emoteId = %s, it doesn't respect the following condition : emoteId < 0 || emoteId > 255", emoteId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.emoteId);
	}
}