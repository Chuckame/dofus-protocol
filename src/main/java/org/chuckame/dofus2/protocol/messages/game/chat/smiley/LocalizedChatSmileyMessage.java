package org.chuckame.dofus2.protocol.messages.game.chat.smiley;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.chat.smiley.ChatSmileyMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class LocalizedChatSmileyMessage extends ChatSmileyMessage {
	public static final int MESSAGE_ID = 6185;
	
	private short cellId;
	
	public LocalizedChatSmileyMessage() {
	}
	
	public LocalizedChatSmileyMessage(int entityId, byte smileyId, int accountId, short cellId) {
		super(entityId, smileyId, accountId);
		this.cellId = cellId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.cellId = reader.readShort();
		if (cellId < 0 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < 0 || cellId > 559", cellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.cellId);
	}
}