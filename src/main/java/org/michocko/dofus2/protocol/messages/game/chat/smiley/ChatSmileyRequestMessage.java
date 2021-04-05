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
public class ChatSmileyRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 800;
	
	private byte smileyId;
	
	public ChatSmileyRequestMessage() {
	}
	
	public ChatSmileyRequestMessage(byte smileyId) {
		this.smileyId = smileyId;
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
		this.smileyId = reader.readSByte();
		if (smileyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on smileyId = %s, it doesn't respect the following condition : smileyId < 0", smileyId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.smileyId);
	}
}