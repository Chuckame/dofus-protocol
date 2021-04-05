package org.michocko.dofus2.protocol.messages.game.inventory.storage;

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
public class StorageObjectUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5647;
	
	private ObjectItem object;
	
	public StorageObjectUpdateMessage() {
	}
	
	public StorageObjectUpdateMessage(ObjectItem object) {
		this.object = object;
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
		this.object = new ObjectItem();
		this.object.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.object.serialize(writer);
	}
}