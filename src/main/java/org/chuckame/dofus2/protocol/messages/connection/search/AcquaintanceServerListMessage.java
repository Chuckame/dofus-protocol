package org.chuckame.dofus2.protocol.messages.connection.search;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AcquaintanceServerListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6142;
	
	private Collection<Short> servers;
	
	public AcquaintanceServerListMessage() {
	}
	
	public AcquaintanceServerListMessage(Collection<Short> servers) {
		this.servers = servers;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.servers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.servers.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.servers.size());
		for (short entry : this.servers)
		{
			writer.writeShort(entry);
		}
	}
}