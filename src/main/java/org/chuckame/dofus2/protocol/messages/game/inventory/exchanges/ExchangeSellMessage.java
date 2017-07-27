package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeSellMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5778;
	
	private int objectToSellId;
	private int quantity;
	
	public ExchangeSellMessage() {
	}
	
	public ExchangeSellMessage(int objectToSellId, int quantity) {
		this.objectToSellId = objectToSellId;
		this.quantity = quantity;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectToSellId = reader.readInt();
		if (objectToSellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectToSellId = %s, it doesn't respect the following condition : objectToSellId < 0", objectToSellId));
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectToSellId);
		writer.writeInt(this.quantity);
	}
}