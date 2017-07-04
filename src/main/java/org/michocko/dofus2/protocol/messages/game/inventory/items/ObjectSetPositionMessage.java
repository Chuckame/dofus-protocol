package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ObjectSetPositionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3021;
	
	private int objectUID;
	private short position;
	private int quantity;
	
	public ObjectSetPositionMessage() {
	}
	
	public ObjectSetPositionMessage(int objectUID, short position, int quantity) {
		this.objectUID = objectUID;
		this.position = position;
		this.quantity = quantity;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
		this.position = reader.readByte();
		if (position < 0 || position > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on position = %s, it doesn't respect the following condition : position < 0 || position > 255", position));
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectUID);
		writer.writeByte(this.position);
		writer.writeInt(this.quantity);
	}
}