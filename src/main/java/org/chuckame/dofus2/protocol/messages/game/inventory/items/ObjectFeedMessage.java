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
public class ObjectFeedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6290;
	
	private int objectUID;
	private int foodUID;
	private short foodQuantity;
	
	public ObjectFeedMessage() {
	}
	
	public ObjectFeedMessage(int objectUID, int foodUID, short foodQuantity) {
		this.objectUID = objectUID;
		this.foodUID = foodUID;
		this.foodQuantity = foodQuantity;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
		this.foodUID = reader.readInt();
		if (foodUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on foodUID = %s, it doesn't respect the following condition : foodUID < 0", foodUID));
		this.foodQuantity = reader.readShort();
		if (foodQuantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on foodQuantity = %s, it doesn't respect the following condition : foodQuantity < 0", foodQuantity));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectUID);
		writer.writeInt(this.foodUID);
		writer.writeShort(this.foodQuantity);
	}
}