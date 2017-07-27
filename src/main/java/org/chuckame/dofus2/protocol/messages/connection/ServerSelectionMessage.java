package org.chuckame.dofus2.protocol.messages.connection;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ServerSelectionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 40;
	
	private short serverId;
	
	public ServerSelectionMessage() {
	}
	
	public ServerSelectionMessage(short serverId) {
		this.serverId = serverId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.serverId = reader.readShort();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.serverId);
	}
}