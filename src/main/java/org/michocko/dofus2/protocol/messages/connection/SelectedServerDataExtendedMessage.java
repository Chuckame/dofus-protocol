package org.michocko.dofus2.protocol.messages.connection;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.messages.connection.SelectedServerDataMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class SelectedServerDataExtendedMessage extends SelectedServerDataMessage {
	public static final int MESSAGE_ID = 6469;
	
	private Collection<Short> serverIds;
	
	public SelectedServerDataExtendedMessage() {
	}
	
	public SelectedServerDataExtendedMessage(short serverId, String address, int port, boolean canCreateNewCharacter, String ticket, Collection<Short> serverIds) {
		super(serverId, address, port, canCreateNewCharacter, ticket);
		this.serverIds = serverIds;
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
		super.deserialize(reader);
		int length = reader.readUShort();
		this.serverIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.serverIds.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.serverIds.size());
		for (short entry : this.serverIds)
		{
			writer.writeShort(entry);
		}
	}
}