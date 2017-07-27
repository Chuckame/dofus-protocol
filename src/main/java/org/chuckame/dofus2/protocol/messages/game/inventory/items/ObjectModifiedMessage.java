package org.chuckame.dofus2.protocol.messages.game.inventory.items;

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
public class ObjectModifiedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3029;
	
	private ObjectItem object;
	
	public ObjectModifiedMessage() {
	}
	
	public ObjectModifiedMessage(ObjectItem object) {
		this.object = object;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.object = new ObjectItem();
		this.object.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.object.serialize(writer);
	}
}