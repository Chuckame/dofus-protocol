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
public class ExchangeShopStockMovementRemovedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5907;
	
	private int objectId;
	
	public ExchangeShopStockMovementRemovedMessage() {
	}
	
	public ExchangeShopStockMovementRemovedMessage(int objectId) {
		this.objectId = objectId;
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
		this.objectId = reader.readInt();
		if (objectId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectId = %s, it doesn't respect the following condition : objectId < 0", objectId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectId);
	}
}