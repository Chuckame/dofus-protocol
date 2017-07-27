package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeItemAutoCraftRemainingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6015;
	
	private int count;
	
	public ExchangeItemAutoCraftRemainingMessage() {
	}
	
	public ExchangeItemAutoCraftRemainingMessage(int count) {
		this.count = count;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.count = reader.readInt();
		if (count < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on count = %s, it doesn't respect the following condition : count < 0", count));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.count);
	}
}