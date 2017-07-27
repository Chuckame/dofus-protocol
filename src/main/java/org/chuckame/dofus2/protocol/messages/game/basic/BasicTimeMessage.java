package org.chuckame.dofus2.protocol.messages.game.basic;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicTimeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 175;
	
	private int timestamp;
	private short timezoneOffset;
	
	public BasicTimeMessage() {
	}
	
	public BasicTimeMessage(int timestamp, short timezoneOffset) {
		this.timestamp = timestamp;
		this.timezoneOffset = timezoneOffset;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.timestamp = reader.readInt();
		if (timestamp < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on timestamp = %s, it doesn't respect the following condition : timestamp < 0", timestamp));
		this.timezoneOffset = reader.readShort();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.timestamp);
		writer.writeShort(this.timezoneOffset);
	}
}