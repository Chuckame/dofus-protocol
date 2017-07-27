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
public class ExchangeWeightMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5793;
	
	private int currentWeight;
	private int maxWeight;
	
	public ExchangeWeightMessage() {
	}
	
	public ExchangeWeightMessage(int currentWeight, int maxWeight) {
		this.currentWeight = currentWeight;
		this.maxWeight = maxWeight;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.currentWeight = reader.readInt();
		if (currentWeight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on currentWeight = %s, it doesn't respect the following condition : currentWeight < 0", currentWeight));
		this.maxWeight = reader.readInt();
		if (maxWeight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxWeight = %s, it doesn't respect the following condition : maxWeight < 0", maxWeight));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.currentWeight);
		writer.writeInt(this.maxWeight);
	}
}