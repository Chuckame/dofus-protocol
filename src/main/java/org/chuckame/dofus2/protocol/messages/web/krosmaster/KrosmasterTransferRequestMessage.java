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
public class KrosmasterTransferRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6349;
	
	private String uid;
	
	public KrosmasterTransferRequestMessage() {
	}
	
	public KrosmasterTransferRequestMessage(String uid) {
		this.uid = uid;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.uid);
	}
}