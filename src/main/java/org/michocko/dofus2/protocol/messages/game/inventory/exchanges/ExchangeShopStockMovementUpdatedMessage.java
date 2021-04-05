package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemToSell;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeShopStockMovementUpdatedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5909;
	
	private ObjectItemToSell objectInfo;
	
	public ExchangeShopStockMovementUpdatedMessage() {
	}
	
	public ExchangeShopStockMovementUpdatedMessage(ObjectItemToSell objectInfo) {
		this.objectInfo = objectInfo;
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
		this.objectInfo = new ObjectItemToSell();
		this.objectInfo.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.objectInfo.serialize(writer);
	}
}