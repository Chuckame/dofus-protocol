package org.michocko.dofus2.protocol.messages.game.inventory.storage;

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
public class StorageObjectsRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6035;
	
	private Collection<Integer> objectUIDList;
	
	public StorageObjectsRemoveMessage() {
	}
	
	public StorageObjectsRemoveMessage(Collection<Integer> objectUIDList) {
		this.objectUIDList = objectUIDList;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectUIDList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.objectUIDList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectUIDList.size());
		for (int entry : this.objectUIDList)
		{
			writer.writeInt(entry);
		}
	}
}