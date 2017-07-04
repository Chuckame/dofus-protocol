package org.michocko.dofus2.protocol.messages.connection.search;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AcquaintanceSearchMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6144;
	
	private String nickname;
	
	public AcquaintanceSearchMessage() {
	}
	
	public AcquaintanceSearchMessage(String nickname) {
		this.nickname = nickname;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.nickname = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.nickname);
	}
}