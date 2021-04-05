package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.protocol.types.game.guild.GuildEmblem;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.guildEmblem = new GuildEmblem();
		this.guildEmblem.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.guildEmblem.serialize(writer);
	}
}