package org.chuckame.dofus2.protocol.messages.game.chat;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.chat.ChatServerCopyMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ChatServerCopyWithObjectMessage extends ChatServerCopyMessage {
	public static final int MESSAGE_ID = 884;
	
	private Collection<ObjectItem> objects;
	
	public ChatServerCopyWithObjectMessage() {
	}
	
	public ChatServerCopyWithObjectMessage(byte channel, String content, int timestamp, String fingerprint, int receiverId, String receiverName, Collection<ObjectItem> objects) {
		super(channel, content, timestamp, fingerprint, receiverId, receiverName);
		this.objects = objects;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.objects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItem entry = new ObjectItem();
			entry.deserialize(reader);
			this.objects.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.objects.size());
		for (ObjectItem entry : this.objects)
		{
			entry.serialize(writer);
		}
	}
}