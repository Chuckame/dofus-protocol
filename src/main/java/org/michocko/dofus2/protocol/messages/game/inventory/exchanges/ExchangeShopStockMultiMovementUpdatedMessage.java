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
public class ExchangeShopStockMultiMovementUpdatedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6038;
	
	private Collection<ObjectItemToSell> objectInfoList;
	
	public ExchangeShopStockMultiMovementUpdatedMessage() {
	}
	
	public ExchangeShopStockMultiMovementUpdatedMessage(Collection<ObjectItemToSell> objectInfoList) {
		this.objectInfoList = objectInfoList;
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
		int length = reader.readUShort();
		this.objectInfoList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItemToSell entry = new ObjectItemToSell();
			entry.deserialize(reader);
			this.objectInfoList.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectInfoList.size());
		for (ObjectItemToSell entry : this.objectInfoList)
		{
			entry.serialize(writer);
		}
	}
}