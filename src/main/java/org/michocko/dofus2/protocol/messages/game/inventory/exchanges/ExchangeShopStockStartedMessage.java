package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

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
public class ExchangeShopStockStartedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5910;
	
	private Collection<ObjectItemToSell> objectsInfos;
	
	public ExchangeShopStockStartedMessage() {
	}
	
	public ExchangeShopStockStartedMessage(Collection<ObjectItemToSell> objectsInfos) {
		this.objectsInfos = objectsInfos;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectsInfos = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemToSell entry = new ObjectItemToSell();
			entry.deserialize(reader);
			this.objectsInfos.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectsInfos.size());
		for (ObjectItemToSell entry : this.objectsInfos)
		{
			entry.serialize(writer);
		}
	}
}