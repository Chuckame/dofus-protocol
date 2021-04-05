package org.michocko.dofus2.protocol.messages.authorized;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ConsoleCommandsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6127;
	
	private Collection<String> aliases;
	private Collection<String> args;
	private Collection<String> descriptions;
	
	public ConsoleCommandsListMessage() {
	}
	
	public ConsoleCommandsListMessage(Collection<String> aliases, Collection<String> args, Collection<String> descriptions) {
		this.aliases = aliases;
		this.args = args;
		this.descriptions = descriptions;
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
		this.aliases = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.aliases.add(entry);
		}
		length = reader.readUShort();
		this.args = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.args.add(entry);
		}
		length = reader.readUShort();
		this.descriptions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.descriptions.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.aliases.size());
		for (String entry : this.aliases)
		{
			writer.writeUTF(entry);
		}
		writer.writeUShort(this.args.size());
		for (String entry : this.args)
		{
			writer.writeUTF(entry);
		}
		writer.writeUShort(this.descriptions.size());
		for (String entry : this.descriptions)
		{
			writer.writeUTF(entry);
		}
	}
}