package org.chuckame.dofus2.protocol.messages.game.inventory.storage;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.items.InventoryContentMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItem;

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
	public int getProtocolId() {
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