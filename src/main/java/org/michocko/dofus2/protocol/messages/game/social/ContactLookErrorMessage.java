package org.michocko.dofus2.protocol.messages.game.social;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ContactLookErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6045;
	
	private int requestId;
	
	public ContactLookErrorMessage() {
	}
	
	public ContactLookErrorMessage(int requestId) {
		this.requestId = requestId;
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
		this.requestId = reader.readInt();
		if (requestId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on requestId = %s, it doesn't respect the following condition : requestId < 0", requestId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.requestId);
	}
}