package org.michocko.dofus2.protocol.messages.game.inventory.items;

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
public class ObjectsDeletedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6034;
	
	private Collection<Integer> objectUID;
	
	public ObjectsDeletedMessage() {
	}
	
	public ObjectsDeletedMessage(Collection<Integer> objectUID) {
		this.objectUID = objectUID;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectUID = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.objectUID.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectUID.size());
		for (int entry : this.objectUID)
		{
			writer.writeInt(entry);
		}
	}
}