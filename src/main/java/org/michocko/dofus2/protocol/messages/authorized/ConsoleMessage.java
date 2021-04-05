package org.michocko.dofus2.protocol.messages.authorized;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ConsoleMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 75;
	
	private byte type;
	private String content;
	
	public ConsoleMessage() {
	}
	
	public ConsoleMessage(byte type, String content) {
		this.type = type;
		this.content = content;
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
		this.type = reader.readSByte();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
		this.content = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.type);
		writer.writeUTF(this.content);
	}
}