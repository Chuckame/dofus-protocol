package org.michocko.dofus2.protocol.messages.game.inventory.items;

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
public class ObjectAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3025;
	
	private ObjectItem object;
	
	public ObjectAddedMessage() {
	}
	
	public ObjectAddedMessage(ObjectItem object) {
		this.object = object;
	}
	
	public int getNetworkMessageId() {
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