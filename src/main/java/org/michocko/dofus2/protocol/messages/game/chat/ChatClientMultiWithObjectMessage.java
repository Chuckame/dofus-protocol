package org.michocko.dofus2.protocol.messages.game.chat;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItem;
import org.michocko.dofus2.protocol.messages.game.chat.ChatClientMultiMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ChatClientMultiWithObjectMessage extends ChatClientMultiMessage {
	public static final int MESSAGE_ID = 862;
	
	private Collection<ObjectItem> objects;
	
	public ChatClientMultiWithObjectMessage() {
	}
	
	public ChatClientMultiWithObjectMessage(String content, byte channel, Collection<ObjectItem> objects) {
		super(content, channel);
		this.objects = objects;
	}
	
	@Override
	public int getNetworkMessageId() {
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