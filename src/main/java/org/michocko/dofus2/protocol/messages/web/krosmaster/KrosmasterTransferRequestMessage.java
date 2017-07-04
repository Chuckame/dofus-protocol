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
public class KrosmasterTransferRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6349;
	
	private String uid;
	
	public KrosmasterTransferRequestMessage() {
	}
	
	public KrosmasterTransferRequestMessage(String uid) {
		this.uid = uid;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.uid);
	}
}