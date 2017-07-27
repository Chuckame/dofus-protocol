package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItemToSellInBid;

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
	
	public int getProtocolId() {
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