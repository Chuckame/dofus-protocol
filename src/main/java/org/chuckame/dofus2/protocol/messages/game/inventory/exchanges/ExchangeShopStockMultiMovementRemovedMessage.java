package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectIdList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.objectIdList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectIdList.size());
		for (int entry : this.objectIdList)
		{
			writer.writeInt(entry);
		}
	}
}