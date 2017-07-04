package org.michocko.dofus2.protocol.messages.game.context.notification;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NotificationListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6087;
	
	private Collection<Integer> flags;
	
	public NotificationListMessage() {
	}
	
	public NotificationListMessage(Collection<Integer> flags) {
		this.flags = flags;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.flags = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.flags.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.flags.size());
		for (int entry : this.flags)
		{
			writer.writeInt(entry);
		}
	}
}