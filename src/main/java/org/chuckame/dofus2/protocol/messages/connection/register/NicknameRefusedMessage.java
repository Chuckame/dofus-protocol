package org.chuckame.dofus2.protocol.messages.connection.register;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NicknameRefusedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5638;
	
	private byte reason;
	
	public NicknameRefusedMessage() {
	}
	
	public NicknameRefusedMessage(byte reason) {
		this.reason = reason;
	}
	
	public int getProtocolId() {
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