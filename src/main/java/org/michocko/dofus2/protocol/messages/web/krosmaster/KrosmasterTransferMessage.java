package org.michocko.dofus2.protocol.messages.web.krosmaster;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class KrosmasterTransferMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6348;
	
	private String uid;
	private byte failure;
	
	public KrosmasterTransferMessage() {
	}
	
	public KrosmasterTransferMessage(String uid, byte failure) {
		this.uid = uid;
		this.failure = failure;
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
		this.uid = reader.readUTF();
		this.failure = reader.readSByte();
		if (failure < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on failure = %s, it doesn't respect the following condition : failure < 0", failure));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.uid);
		writer.writeSByte(this.failure);
	}
}