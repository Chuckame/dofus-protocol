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
public class GuildModificationValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6323;
	
	private String guildName;
	private GuildEmblem guildEmblem;
	
	public GuildModificationValidMessage() {
	}
	
	public GuildModificationValidMessage(String guildName, GuildEmblem guildEmblem) {
		this.guildName = guildName;
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
		this.guildName = reader.readUTF();
		this.guildEmblem = new GuildEmblem();
		this.guildEmblem.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.guildName);
		this.guildEmblem.serialize(writer);
	}
}