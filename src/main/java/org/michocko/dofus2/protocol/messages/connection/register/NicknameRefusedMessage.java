package org.michocko.dofus2.protocol.messages.connection.register;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.reason = reader.readSByte();
		if (reason < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on reason = %s, it doesn't respect the following condition : reason < 0", reason));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.reason);
	}
}