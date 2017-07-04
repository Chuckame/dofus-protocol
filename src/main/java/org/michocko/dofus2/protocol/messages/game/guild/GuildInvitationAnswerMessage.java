package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInvitationAnswerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5556;
	
	private boolean accept;
	
	public GuildInvitationAnswerMessage() {
	}
	
	public GuildInvitationAnswerMessage(boolean accept) {
		this.accept = accept;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.accept = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.accept);
	}
}