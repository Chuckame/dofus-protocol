package org.michocko.dofus2.protocol.messages.connection;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.serverId = reader.readShort();
		this.address = reader.readUTF();
		this.port = reader.readUShort();
		if (port < 0 || port > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on port = %s, it doesn't respect the following condition : port < 0 || port > 65535", port));
		this.canCreateNewCharacter = reader.readBoolean();
		this.ticket = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.serverId);
		writer.writeUTF(this.address);
		writer.writeUShort(this.port);
		writer.writeBoolean(this.canCreateNewCharacter);
		writer.writeUTF(this.ticket);
	}
}