package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeShopStockMultiMovementRemovedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6037;
	
	private Collection<Integer> objectIdList;
	
	public ExchangeShopStockMultiMovementRemovedMessage() {
	}
	
	public ExchangeShopStockMultiMovementRemovedMessage(Collection<Integer> objectIdList) {
		this.objectIdList = objectIdList;
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
		this.objectIdList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.objectIdList.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectIdList.size());
		for (int entry : this.objectIdList)
		{
			writer.writeInt(entry);
		}
	}
}