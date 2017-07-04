package org.michocko.dofus2.protocol.messages.game.inventory;

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
public class ObjectAveragePricesMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6335;
	
	private Collection<Short> ids;
	private Collection<Integer> avgPrices;
	
	public ObjectAveragePricesMessage() {
	}
	
	public ObjectAveragePricesMessage(Collection<Short> ids, Collection<Integer> avgPrices) {
		this.ids = ids;
		this.avgPrices = avgPrices;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.ids = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.ids.add(entry);
		}
		length = reader.readUShort();
		this.avgPrices = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.avgPrices.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.ids.size());
		for (short entry : this.ids)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.avgPrices.size());
		for (int entry : this.avgPrices)
		{
			writer.writeInt(entry);
		}
	}
}