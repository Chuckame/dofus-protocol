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
public class GuildFactsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6404;
	
	private int guildId;
	
	public GuildFactsRequestMessage() {
	}
	
	public GuildFactsRequestMessage(int guildId) {
		this.guildId = guildId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.guildId = reader.readInt();
		if (guildId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guildId = %s, it doesn't respect the following condition : guildId < 0", guildId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.guildId);
	}
}