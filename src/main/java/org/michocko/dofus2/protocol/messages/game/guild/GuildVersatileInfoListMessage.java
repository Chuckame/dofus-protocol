package org.michocko.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.social.GuildVersatileInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildVersatileInfoListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6435;
	
	private Collection<GuildVersatileInformations> guilds;
	
	public GuildVersatileInfoListMessage() {
	}
	
	public GuildVersatileInfoListMessage(Collection<GuildVersatileInformations> guilds) {
		this.guilds = guilds;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.guilds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GuildVersatileInformations entry = ProtocolTypeManager.getInstance().<GuildVersatileInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.guilds.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.guilds.size());
		for (GuildVersatileInformations entry : this.guilds)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}