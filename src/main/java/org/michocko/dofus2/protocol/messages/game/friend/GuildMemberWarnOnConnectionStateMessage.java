package org.michocko.dofus2.protocol.messages.game.friend;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildMemberWarnOnConnectionStateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6160;
	
	private boolean enable;
	
	public GuildMemberWarnOnConnectionStateMessage() {
	}
	
	public GuildMemberWarnOnConnectionStateMessage(boolean enable) {
		this.enable = enable;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.enable = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enable);
	}
}