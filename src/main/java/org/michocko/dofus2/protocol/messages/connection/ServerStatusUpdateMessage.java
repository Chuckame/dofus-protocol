package org.michocko.dofus2.protocol.messages.connection;

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
public class ServerStatusUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 50;
	
	private GameServerInformations server;
	
	public ServerStatusUpdateMessage() {
	}
	
	public ServerStatusUpdateMessage(GameServerInformations server) {
		this.server = server;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.server = new GameServerInformations();
		this.server.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.server.serialize(writer);
	}
}