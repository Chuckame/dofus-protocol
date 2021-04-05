package org.michocko.dofus2.protocol.messages.game.inventory.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItem;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InventoryContentMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3016;
	
	private Collection<ObjectItem> objects;
	private int kamas;
	
	public InventoryContentMessage() {
	}
	
	public InventoryContentMessage(Collection<ObjectItem> objects, int kamas) {
		this.objects = objects;
		this.kamas = kamas;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItem entry = new ObjectItem();
			entry.deserialize(reader);
			this.objects.add(entry);
		}
		this.kamas = reader.readInt();
		if (kamas < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kamas = %s, it doesn't respect the following condition : kamas < 0", kamas));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objects.size());
		for (ObjectItem entry : this.objects)
		{
			entry.serialize(writer);
		}
		writer.writeInt(this.kamas);
	}
}