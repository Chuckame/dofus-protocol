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
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectInfo = new ObjectItemToSell();
		this.objectInfo.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.objectInfo.serialize(writer);
	}
}