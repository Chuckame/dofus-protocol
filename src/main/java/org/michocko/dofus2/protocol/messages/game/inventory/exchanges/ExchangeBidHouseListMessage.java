package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeBidHouseListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5807;
	
	private int id;
	
	public ExchangeBidHouseListMessage() {
	}
	
	public ExchangeBidHouseListMessage(int id) {
		this.id = id;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
	}
}