package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ObjectDeletedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3024;
	
	private int objectUID;
	
	public ObjectDeletedMessage() {
	}
	
	public ObjectDeletedMessage(int objectUID) {
		this.objectUID = objectUID;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectUID);
	}
}