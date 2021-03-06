package org.chuckame.dofus2.protocol.messages.game.approach;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.approach.ServerSessionConstant;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.variables = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ServerSessionConstant entry = ProtocolTypeManager.getInstance().<ServerSessionConstant>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.variables.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.variables.size());
		for (ServerSessionConstant entry : this.variables)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}