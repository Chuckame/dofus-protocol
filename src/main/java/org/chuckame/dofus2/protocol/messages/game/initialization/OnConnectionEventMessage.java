package org.chuckame.dofus2.protocol.messages.game.initialization;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
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