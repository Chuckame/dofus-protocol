package org.michocko.dofus2.protocol.messages.connection;

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
public class HelloConnectMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3;
	
	private String salt;
	private Collection<Byte> key;
	
	public HelloConnectMessage() {
	}
	
	public HelloConnectMessage(String salt, Collection<Byte> key) {
		this.salt = salt;
		this.key = key;
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
		this.salt = reader.readUTF();
		int length = reader.readUShort();
		this.key = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.key.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.salt);
		writer.writeUShort(this.key.size());
		for (byte entry : this.key)
		{
			writer.writeSByte(entry);
		}
	}
}