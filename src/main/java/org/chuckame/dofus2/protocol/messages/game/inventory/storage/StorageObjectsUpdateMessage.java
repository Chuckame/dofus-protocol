package org.chuckame.dofus2.protocol.messages.game.inventory.storage;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StorageObjectsUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6036;
	
	private Collection<ObjectItem> objectList;
	
	public StorageObjectsUpdateMessage() {
	}
	
	public StorageObjectsUpdateMessage(Collection<ObjectItem> objectList) {
		this.objectList = objectList;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItem entry = new ObjectItem();
			entry.deserialize(reader);
			this.objectList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectList.size());
		for (ObjectItem entry : this.objectList)
		{
			entry.serialize(writer);
		}
	}
}