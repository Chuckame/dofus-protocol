package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeStartedMountStockMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5984;
	
	private Collection<ObjectItem> objectsInfos;
	
	public ExchangeStartedMountStockMessage() {
	}
	
	public ExchangeStartedMountStockMessage(Collection<ObjectItem> objectsInfos) {
		this.objectsInfos = objectsInfos;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.objectsInfos = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItem entry = new ObjectItem();
			entry.deserialize(reader);
			this.objectsInfos.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.objectsInfos.size());
		for (ObjectItem entry : this.objectsInfos)
		{
			entry.serialize(writer);
		}
	}
}