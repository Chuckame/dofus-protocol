package org.chuckame.dofus2.protocol.messages.game.social;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.requestId = reader.readInt();
		if (requestId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on requestId = %s, it doesn't respect the following condition : requestId < 0", requestId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.requestId);
	}
}