package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeObjectMoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5518;
	
	private int objectUID;
	private int quantity;
	
	public ExchangeObjectMoveMessage() {
	}
	
	public ExchangeObjectMoveMessage(int objectUID, int quantity) {
		this.objectUID = objectUID;
		this.quantity = quantity;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
		this.quantity = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectUID);
		writer.writeInt(this.quantity);
	}
}