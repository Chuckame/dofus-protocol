package org.chuckame.dofus2.protocol.messages.game.context.roleplay.lockable;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LockableChangeCodeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5666;
	
	private String code;
	
	public LockableChangeCodeMessage() {
	}
	
	public LockableChangeCodeMessage(String code) {
		this.code = code;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.code = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.code);
	}
}