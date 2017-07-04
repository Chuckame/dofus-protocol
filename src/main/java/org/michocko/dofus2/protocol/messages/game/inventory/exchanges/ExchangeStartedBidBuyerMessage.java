package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.types.game.data.items.SellerBuyerDescriptor;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeStartedBidBuyerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5904;
	
	private SellerBuyerDescriptor buyerDescriptor;
	
	public ExchangeStartedBidBuyerMessage() {
	}
	
	public ExchangeStartedBidBuyerMessage(SellerBuyerDescriptor buyerDescriptor) {
		this.buyerDescriptor = buyerDescriptor;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.buyerDescriptor = new SellerBuyerDescriptor();
		this.buyerDescriptor.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.buyerDescriptor.serialize(writer);
	}
}