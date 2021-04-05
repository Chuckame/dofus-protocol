package org.michocko.dofus2.protocol.messages.game.approach;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.approach.ServerSessionConstant;

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
public class ServerSessionConstantsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6434;
	
	private Collection<ServerSessionConstant> variables;
	
	public ServerSessionConstantsMessage() {
	}
	
	public ServerSessionConstantsMessage(Collection<ServerSessionConstant> variables) {
		this.variables = variables;
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
		int length = reader.readUShort();
		this.variables = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ServerSessionConstant entry = (ServerSessionConstant) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.variables.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.variables.size());
		for (ServerSessionConstant entry : this.variables)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}