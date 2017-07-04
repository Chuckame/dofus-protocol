package org.michocko.dofus2.protocol.messages.connection;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.connection.GameServerInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ServersListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 30;
	
	private Collection<GameServerInformations> servers;
	
	public ServersListMessage() {
	}
	
	public ServersListMessage(Collection<GameServerInformations> servers) {
		this.servers = servers;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.servers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameServerInformations entry = new GameServerInformations();
			entry.deserialize(reader);
			this.servers.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.servers.size());
		for (GameServerInformations entry : this.servers)
		{
			entry.serialize(writer);
		}
	}
}