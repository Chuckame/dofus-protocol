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
public class ClientKeyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5607;
	
	private String key;
	
	public ClientKeyMessage() {
	}
	
	public ClientKeyMessage(String key) {
		this.key = key;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.key = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.key);
	}
}