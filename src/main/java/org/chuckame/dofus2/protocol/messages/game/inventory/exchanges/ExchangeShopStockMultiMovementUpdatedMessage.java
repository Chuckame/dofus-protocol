package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItemToSell;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeShopStockMultiMovementUpdatedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6038;
	
	private Collection<ObjectItemToSell> objectInfoList;
	
	public ExchangeShopStockMultiMovementUpdatedMessage() {
	}
	
	public ExchangeShopStockMultiMovementUpdatedMessage(Collection<ObjectItemToSell> objectInfoList) {
		this.objectInfoList = objectInfoList;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectInfoList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemToSell entry = new ObjectItemToSell();
			entry.deserialize(reader);
			this.objectInfoList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectInfoList.size());
		for (ObjectItemToSell entry : this.objectInfoList)
		{
			entry.serialize(writer);
		}
	}
}