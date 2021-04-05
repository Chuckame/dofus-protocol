package org.michocko.dofus2.protocol.messages.game.inventory.storage;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItem;
import org.michocko.dofus2.protocol.messages.game.inventory.items.InventoryContentMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class StorageInventoryContentMessage extends InventoryContentMessage {
	public static final int MESSAGE_ID = 5646;
	
	
	public StorageInventoryContentMessage() {
	}
	
	public StorageInventoryContentMessage(Collection<ObjectItem> objects, int kamas) {
		super(objects, kamas);
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
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}