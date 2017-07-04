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
public class ExchangeTypesExchangerDescriptionForUserMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5765;
	
	private Collection<Integer> typeDescription;
	
	public ExchangeTypesExchangerDescriptionForUserMessage() {
	}
	
	public ExchangeTypesExchangerDescriptionForUserMessage(Collection<Integer> typeDescription) {
		this.typeDescription = typeDescription;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.typeDescription = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.typeDescription.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.typeDescription.size());
		for (int entry : this.typeDescription)
		{
			writer.writeInt(entry);
		}
	}
}