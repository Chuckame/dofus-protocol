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
public class GuildModificationNameValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6327;
	
	private String guildName;
	
	public GuildModificationNameValidMessage() {
	}
	
	public GuildModificationNameValidMessage(String guildName) {
		this.guildName = guildName;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.guildName = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.guildName);
	}
}