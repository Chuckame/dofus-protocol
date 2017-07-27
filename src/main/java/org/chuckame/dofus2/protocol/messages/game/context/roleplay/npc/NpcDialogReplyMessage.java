package org.chuckame.dofus2.protocol.messages.game.context.roleplay.npc;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NpcDialogReplyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5616;
	
	private short replyId;
	
	public NpcDialogReplyMessage() {
	}
	
	public NpcDialogReplyMessage(short replyId) {
		this.replyId = replyId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.replyId = reader.readShort();
		if (replyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on replyId = %s, it doesn't respect the following condition : replyId < 0", replyId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.replyId);
	}
}