package org.chuckame.dofus2.protocol.messages.game.context.notification;

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
public class NotificationByServerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6103;
	
	private int id;
	private Collection<String> parameters;
	private boolean forceOpen;
	
	public NotificationByServerMessage() {
	}
	
	public NotificationByServerMessage(int id, Collection<String> parameters, boolean forceOpen) {
		this.id = id;
		this.parameters = parameters;
		this.forceOpen = forceOpen;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readUShort();
		if (id < 0 || id > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0 || id > 65535", id));
		int length = reader.readUShort();
		this.parameters = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.parameters.add(entry);
		}
		this.forceOpen = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.id);
		writer.writeUShort(this.parameters.size());
		for (String entry : this.parameters)
		{
			writer.writeUTF(entry);
		}
		writer.writeBoolean(this.forceOpen);
	}
}