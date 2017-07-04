package org.michocko.dofus2.protocol.messages.updater.parts;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GetPartInfoMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1506;
	
	private String id;
	
	public GetPartInfoMessage() {
	}
	
	public GetPartInfoMessage(String id) {
		this.id = id;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.id);
	}
}