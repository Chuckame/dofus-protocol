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
public class ExchangeObjectTransfertListFromInvMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6183;
	
	private Collection<Integer> ids;
	
	public ExchangeObjectTransfertListFromInvMessage() {
	}
	
	public ExchangeObjectTransfertListFromInvMessage(Collection<Integer> ids) {
		this.ids = ids;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.ids = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.ids.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.ids.size());
		for (int entry : this.ids)
		{
			writer.writeInt(entry);
		}
	}
}