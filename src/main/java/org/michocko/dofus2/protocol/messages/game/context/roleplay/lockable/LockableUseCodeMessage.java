package org.michocko.dofus2.protocol.messages.game.context.roleplay.lockable;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LockableUseCodeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5667;
	
	private String code;
	
	public LockableUseCodeMessage() {
	}
	
	public LockableUseCodeMessage(String code) {
		this.code = code;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.code = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.code);
	}
}