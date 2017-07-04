package org.michocko.dofus2.protocol.messages.game.inventory.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemQuantity;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ObjectsQuantityMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6206;
	
	private Collection<ObjectItemQuantity> objectsUIDAndQty;
	
	public ObjectsQuantityMessage() {
	}
	
	public ObjectsQuantityMessage(Collection<ObjectItemQuantity> objectsUIDAndQty) {
		this.objectsUIDAndQty = objectsUIDAndQty;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectsUIDAndQty = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemQuantity entry = new ObjectItemQuantity();
			entry.deserialize(reader);
			this.objectsUIDAndQty.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectsUIDAndQty.size());
		for (ObjectItemQuantity entry : this.objectsUIDAndQty)
		{
			entry.serialize(writer);
		}
	}
}