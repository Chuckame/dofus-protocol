package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.guild.GuildEmblem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildModificationEmblemValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6328;
	
	private GuildEmblem guildEmblem;
	
	public GuildModificationEmblemValidMessage() {
	}
	
	public GuildModificationEmblemValidMessage(GuildEmblem guildEmblem) {
		this.guildEmblem = guildEmblem;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.guildEmblem = new GuildEmblem();
		this.guildEmblem.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.guildEmblem.serialize(writer);
	}
}