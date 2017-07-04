package org.michocko.dofus2.protocol.messages.game.context.notification;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NotificationUpdateFlagMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6090;
	
	private short index;
	
	public NotificationUpdateFlagMessage() {
	}
	
	public NotificationUpdateFlagMessage(short index) {
		this.index = index;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.index = reader.readShort();
		if (index < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on index = %s, it doesn't respect the following condition : index < 0", index));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.index);
	}
}