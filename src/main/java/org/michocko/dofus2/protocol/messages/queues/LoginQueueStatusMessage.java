package org.michocko.dofus2.protocol.messages.queues;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LoginQueueStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 10;
	
	private int position;
	private int total;
	
	public LoginQueueStatusMessage() {
	}
	
	public LoginQueueStatusMessage(int position, int total) {
		this.position = position;
		this.total = total;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.position = reader.readUShort();
		if (position < 0 || position > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on position = %s, it doesn't respect the following condition : position < 0 || position > 65535", position));
		this.total = reader.readUShort();
		if (total < 0 || total > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on total = %s, it doesn't respect the following condition : total < 0 || total > 65535", total));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.position);
		writer.writeUShort(this.total);
	}
}