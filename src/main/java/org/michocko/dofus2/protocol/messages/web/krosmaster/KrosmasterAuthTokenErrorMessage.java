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
public class KrosmasterAuthTokenErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6345;
	
	private byte reason;
	
	public KrosmasterAuthTokenErrorMessage() {
	}
	
	public KrosmasterAuthTokenErrorMessage(byte reason) {
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