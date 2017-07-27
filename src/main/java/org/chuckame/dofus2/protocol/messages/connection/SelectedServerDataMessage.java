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
public class SelectedServerDataMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 42;
	
	private short serverId;
	private String address;
	private int port;
	private boolean canCreateNewCharacter;
	private String ticket;
	
	public SelectedServerDataMessage() {
	}
	
	public SelectedServerDataMessage(short serverId, String address, int port, boolean canCreateNewCharacter, String ticket) {
		this.serverId = serverId;
		this.address = address;
		this.port = port;
		this.canCreateNewCharacter = canCreateNewCharacter;
		this.ticket = ticket;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.serverId = reader.readShort();
		this.address = reader.readUTF();
		this.port = reader.readUShort();
		if (port < 0 || port > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on port = %s, it doesn't respect the following condition : port < 0 || port > 65535", port));
		this.canCreateNewCharacter = reader.readBoolean();
		this.ticket = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.serverId);
		writer.writeUTF(this.address);
		writer.writeUShort(this.port);
		writer.writeBoolean(this.canCreateNewCharacter);
		writer.writeUTF(this.ticket);
	}
}