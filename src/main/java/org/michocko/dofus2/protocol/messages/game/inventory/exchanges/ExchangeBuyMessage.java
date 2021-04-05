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
public class ExchangeBuyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5774;
	
	private int objectToBuyId;
	private int quantity;
	
	public ExchangeBuyMessage() {
	}
	
	public ExchangeBuyMessage(int objectToBuyId, int quantity) {
		this.objectToBuyId = objectToBuyId;
		this.quantity = quantity;
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
		this.objectToBuyId = reader.readInt();
		if (objectToBuyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectToBuyId = %s, it doesn't respect the following condition : objectToBuyId < 0", objectToBuyId));
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectToBuyId);
		writer.writeInt(this.quantity);
	}
}