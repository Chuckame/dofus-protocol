package org.michocko.dofus2.protocol.messages.security;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CheckFileMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6156;
	
	private String filenameHash;
	private byte type;
	private String value;
	
	public CheckFileMessage() {
	}
	
	public CheckFileMessage(String filenameHash, byte type, String value) {
		this.filenameHash = filenameHash;
		this.type = type;
		this.value = value;
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
		this.filenameHash = reader.readUTF();
		this.type = reader.readSByte();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
		this.value = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.filenameHash);
		writer.writeSByte(this.type);
		writer.writeUTF(this.value);
	}
}