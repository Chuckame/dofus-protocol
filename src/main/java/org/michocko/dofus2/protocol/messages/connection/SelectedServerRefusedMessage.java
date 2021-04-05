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
public class SelectedServerRefusedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 41;
	
	private short serverId;
	private byte error;
	private byte serverStatus;
	
	public SelectedServerRefusedMessage() {
	}
	
	public SelectedServerRefusedMessage(short serverId, byte error, byte serverStatus) {
		this.serverId = serverId;
		this.error = error;
		this.serverStatus = serverStatus;
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
		this.error = reader.readSByte();
		if (error < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on error = %s, it doesn't respect the following condition : error < 0", error));
		this.serverStatus = reader.readSByte();
		if (serverStatus < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on serverStatus = %s, it doesn't respect the following condition : serverStatus < 0", serverStatus));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.serverId);
		writer.writeSByte(this.error);
		writer.writeSByte(this.serverStatus);
	}
}