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
public class ObjectMovementMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3010;
	
	private int objectUID;
	private short position;
	
	public ObjectMovementMessage() {
	}
	
	public ObjectMovementMessage(int objectUID, short position) {
		this.objectUID = objectUID;
		this.position = position;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
		this.position = reader.readByte();
		if (position < 0 || position > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on position = %s, it doesn't respect the following condition : position < 0 || position > 255", position));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectUID);
		writer.writeByte(this.position);
	}
}