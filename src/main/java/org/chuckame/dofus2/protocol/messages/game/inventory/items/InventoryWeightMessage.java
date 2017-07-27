package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InventoryWeightMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 3009;
	
	private int weight;
	private int weightMax;
	
	public InventoryWeightMessage() {
	}
	
	public InventoryWeightMessage(int weight, int weightMax) {
		this.weight = weight;
		this.weightMax = weightMax;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.weight = reader.readInt();
		if (weight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on weight = %s, it doesn't respect the following condition : weight < 0", weight));
		this.weightMax = reader.readInt();
		if (weightMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on weightMax = %s, it doesn't respect the following condition : weightMax < 0", weightMax));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.weight);
		writer.writeInt(this.weightMax);
	}
}