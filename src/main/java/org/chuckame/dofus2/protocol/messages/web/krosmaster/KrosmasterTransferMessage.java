package org.chuckame.dofus2.protocol.messages.web.krosmaster;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readUTF();
		this.failure = reader.readSByte();
		if (failure < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on failure = %s, it doesn't respect the following condition : failure < 0", failure));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.uid);
		writer.writeSByte(this.failure);
	}
}