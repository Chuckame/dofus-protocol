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
public class LockableCodeResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5672;
	
	private byte result;
	
	public LockableCodeResultMessage() {
	}
	
	public LockableCodeResultMessage(byte result) {
		this.result = result;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.result = reader.readSByte();
		if (result < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on result = %s, it doesn't respect the following condition : result < 0", result));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.result);
	}
}