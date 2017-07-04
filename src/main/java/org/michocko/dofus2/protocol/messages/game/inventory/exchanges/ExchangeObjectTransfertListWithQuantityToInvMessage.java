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
public class ExchangeObjectTransfertListWithQuantityToInvMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6470;
	
	private Collection<Integer> ids;
	private Collection<Integer> qtys;
	
	public ExchangeObjectTransfertListWithQuantityToInvMessage() {
	}
	
	public ExchangeObjectTransfertListWithQuantityToInvMessage(Collection<Integer> ids, Collection<Integer> qtys) {
		this.ids = ids;
		this.qtys = qtys;
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
		length = reader.readUShort();
		this.qtys = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.qtys.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.ids.size());
		for (int entry : this.ids)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.qtys.size());
		for (int entry : this.qtys)
		{
			writer.writeInt(entry);
		}
	}
}