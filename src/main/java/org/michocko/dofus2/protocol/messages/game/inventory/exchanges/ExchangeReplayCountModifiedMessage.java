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
public class ExchangeReplayCountModifiedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6023;
	
	private int count;
	
	public ExchangeReplayCountModifiedMessage() {
	}
	
	public ExchangeReplayCountModifiedMessage(int count) {
		this.count = count;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.count = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.count);
	}
}