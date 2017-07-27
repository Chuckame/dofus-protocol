package org.chuckame.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GuildInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6413;
	
	private Collection<GuildInformations> guilds;
	
	public GuildListMessage() {
	}
	
	public GuildListMessage(Collection<GuildInformations> guilds) {
		this.guilds = guilds;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.guilds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GuildInformations entry = new GuildInformations();
			entry.deserialize(reader);
			this.guilds.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.guilds.size());
		for (GuildInformations entry : this.guilds)
		{
			entry.serialize(writer);
		}
	}
}