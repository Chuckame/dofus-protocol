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
public class CheckFileRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6154;
	
	private String filename;
	private byte type;
	
	public CheckFileRequestMessage() {
	}
	
	public CheckFileRequestMessage(String filename, byte type) {
		this.filename = filename;
		this.type = type;
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
		this.filename = reader.readUTF();
		this.type = reader.readSByte();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.filename);
		writer.writeSByte(this.type);
	}
}