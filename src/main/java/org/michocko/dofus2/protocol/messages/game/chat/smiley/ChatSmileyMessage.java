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
public class ChatSmileyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 801;
	
	private int entityId;
	private byte smileyId;
	private int accountId;
	
	public ChatSmileyMessage() {
	}
	
	public ChatSmileyMessage(int entityId, byte smileyId, int accountId) {
		this.entityId = entityId;
		this.smileyId = smileyId;
		this.accountId = accountId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.entityId = reader.readInt();
		this.smileyId = reader.readSByte();
		if (smileyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on smileyId = %s, it doesn't respect the following condition : smileyId < 0", smileyId));
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.entityId);
		writer.writeSByte(this.smileyId);
		writer.writeInt(this.accountId);
	}
}