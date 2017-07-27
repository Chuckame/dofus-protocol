package org.chuckame.dofus2.protocol.messages.server.basic;

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
public class SystemMessageDisplayMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 189;
	
	private boolean hangUp;
	private short msgId;
	private Collection<String> parameters;
	
	public SystemMessageDisplayMessage() {
	}
	
	public SystemMessageDisplayMessage(boolean hangUp, short msgId, Collection<String> parameters) {
		this.hangUp = hangUp;
		this.msgId = msgId;
		this.parameters = parameters;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.hangUp = reader.readBoolean();
		this.msgId = reader.readShort();
		if (msgId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on msgId = %s, it doesn't respect the following condition : msgId < 0", msgId));
		int length = reader.readUShort();
		this.parameters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.parameters.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.hangUp);
		writer.writeShort(this.msgId);
		writer.writeUShort(this.parameters.size());
		for (String entry : this.parameters)
		{
			writer.writeUTF(entry);
		}
	}
}