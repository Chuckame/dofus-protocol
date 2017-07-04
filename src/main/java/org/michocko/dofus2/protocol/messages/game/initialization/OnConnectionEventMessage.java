package org.michocko.dofus2.protocol.messages.game.initialization;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class OnConnectionEventMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5726;
	
	private byte eventType;
	
	public OnConnectionEventMessage() {
	}
	
	public OnConnectionEventMessage(byte eventType) {
		this.eventType = eventType;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.eventType = reader.readSByte();
		if (eventType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on eventType = %s, it doesn't respect the following condition : eventType < 0", eventType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.eventType);
	}
}