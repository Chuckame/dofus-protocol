package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.weight = reader.readInt();
		if (weight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on weight = %s, it doesn't respect the following condition : weight < 0", weight));
		this.weightMax = reader.readInt();
		if (weightMax < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on weightMax = %s, it doesn't respect the following condition : weightMax < 0", weightMax));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.weight);
		writer.writeInt(this.weightMax);
	}
}