package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItemToSellInHumanVendorShop;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeStartOkHumanVendorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5767;
	
	private int sellerId;
	private Collection<ObjectItemToSellInHumanVendorShop> objectsInfos;
	
	public ExchangeStartOkHumanVendorMessage() {
	}
	
	public ExchangeStartOkHumanVendorMessage(int sellerId, Collection<ObjectItemToSellInHumanVendorShop> objectsInfos) {
		this.sellerId = sellerId;
		this.objectsInfos = objectsInfos;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.sellerId = reader.readInt();
		if (sellerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on sellerId = %s, it doesn't respect the following condition : sellerId < 0", sellerId));
		int length = reader.readUShort();
		this.objectsInfos = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemToSellInHumanVendorShop entry = new ObjectItemToSellInHumanVendorShop();
			entry.deserialize(reader);
			this.objectsInfos.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.sellerId);
		writer.writeUShort(this.objectsInfos.size());
		for (ObjectItemToSellInHumanVendorShop entry : this.objectsInfos)
		{
			entry.serialize(writer);
		}
	}
}