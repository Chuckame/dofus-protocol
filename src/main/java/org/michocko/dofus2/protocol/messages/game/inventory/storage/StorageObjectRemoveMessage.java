package org.michocko.dofus2.protocol.messages.game.inventory.storage;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StorageObjectRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5648;
	
	private int objectUID;
	
	public StorageObjectRemoveMessage() {
	}
	
	public StorageObjectRemoveMessage(int objectUID) {
		this.objectUID = objectUID;
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
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectUID);
	}
}