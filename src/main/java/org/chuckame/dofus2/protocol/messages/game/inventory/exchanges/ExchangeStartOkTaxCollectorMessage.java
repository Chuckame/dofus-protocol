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
public class ExchangeStartOkTaxCollectorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5780;
	
	private int collectorId;
	private Collection<ObjectItem> objectsInfos;
	private int goldInfo;
	
	public ExchangeStartOkTaxCollectorMessage() {
	}
	
	public ExchangeStartOkTaxCollectorMessage(int collectorId, Collection<ObjectItem> objectsInfos, int goldInfo) {
		this.collectorId = collectorId;
		this.objectsInfos = objectsInfos;
		this.goldInfo = goldInfo;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.collectorId = reader.readInt();
		int length = reader.readUShort();
		this.objectsInfos = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ObjectItem entry = new ObjectItem();
			entry.deserialize(reader);
			this.objectsInfos.add(entry);
		}
		this.goldInfo = reader.readInt();
		if (goldInfo < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on goldInfo = %s, it doesn't respect the following condition : goldInfo < 0", goldInfo));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.collectorId);
		writer.writeUShort(this.objectsInfos.size());
		for (ObjectItem entry : this.objectsInfos)
		{
			entry.serialize(writer);
		}
		writer.writeInt(this.goldInfo);
	}
}