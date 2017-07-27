package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.BidExchangerObjectInfo;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeTypesItemsExchangerDescriptionForUserMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5752;
	
	private Collection<BidExchangerObjectInfo> itemTypeDescriptions;
	
	public ExchangeTypesItemsExchangerDescriptionForUserMessage() {
	}
	
	public ExchangeTypesItemsExchangerDescriptionForUserMessage(Collection<BidExchangerObjectInfo> itemTypeDescriptions) {
		this.itemTypeDescriptions = itemTypeDescriptions;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.itemTypeDescriptions = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			BidExchangerObjectInfo entry = new BidExchangerObjectInfo();
			entry.deserialize(reader);
			this.itemTypeDescriptions.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.itemTypeDescriptions.size());
		for (BidExchangerObjectInfo entry : this.itemTypeDescriptions)
		{
			entry.serialize(writer);
		}
	}
}