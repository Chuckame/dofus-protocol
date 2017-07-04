package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemToSellInBid;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeBidHouseItemAddOkMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5945;
	
	private ObjectItemToSellInBid itemInfo;
	
	public ExchangeBidHouseItemAddOkMessage() {
	}
	
	public ExchangeBidHouseItemAddOkMessage(ObjectItemToSellInBid itemInfo) {
		this.itemInfo = itemInfo;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.itemInfo = new ObjectItemToSellInBid();
		this.itemInfo.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.itemInfo.serialize(writer);
	}
}