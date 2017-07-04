package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.data.items.SellerBuyerDescriptor;
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
public class ExchangeStartedBidSellerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5905;
	
	private SellerBuyerDescriptor sellerDescriptor;
	private Collection<ObjectItemToSellInBid> objectsInfos;
	
	public ExchangeStartedBidSellerMessage() {
	}
	
	public ExchangeStartedBidSellerMessage(SellerBuyerDescriptor sellerDescriptor, Collection<ObjectItemToSellInBid> objectsInfos) {
		this.sellerDescriptor = sellerDescriptor;
		this.objectsInfos = objectsInfos;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.sellerDescriptor = new SellerBuyerDescriptor();
		this.sellerDescriptor.deserialize(reader);
		int length = reader.readUShort();
		this.objectsInfos = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemToSellInBid entry = new ObjectItemToSellInBid();
			entry.deserialize(reader);
			this.objectsInfos.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		this.sellerDescriptor.serialize(writer);
		writer.writeUShort(this.objectsInfos.size());
		for (ObjectItemToSellInBid entry : this.objectsInfos)
		{
			entry.serialize(writer);
		}
	}
}