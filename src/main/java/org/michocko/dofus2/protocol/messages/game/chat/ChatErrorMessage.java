package org.michocko.dofus2.protocol.messages.game.chat;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ChatErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 870;
	
	private byte reason;
	
	public ChatErrorMessage() {
	}
	
	public ChatErrorMessage(byte reason) {
		this.reason = reason;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.reason = reader.readSByte();
		if (reason < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on reason = %s, it doesn't respect the following condition : reason < 0", reason));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.reason);
	}
}