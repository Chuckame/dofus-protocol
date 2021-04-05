package org.michocko.dofus2.protocol.messages.game.context.roleplay.paddock;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PaddockToSellFilterMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6161;
	
	private int areaId;
	private byte atLeastNbMount;
	private byte atLeastNbMachine;
	private int maxPrice;
	
	public PaddockToSellFilterMessage() {
	}
	
	public PaddockToSellFilterMessage(int areaId, byte atLeastNbMount, byte atLeastNbMachine, int maxPrice) {
		this.areaId = areaId;
		this.atLeastNbMount = atLeastNbMount;
		this.atLeastNbMachine = atLeastNbMachine;
		this.maxPrice = maxPrice;
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
		this.areaId = reader.readInt();
		this.atLeastNbMount = reader.readSByte();
		this.atLeastNbMachine = reader.readSByte();
		this.maxPrice = reader.readInt();
		if (maxPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxPrice = %s, it doesn't respect the following condition : maxPrice < 0", maxPrice));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.areaId);
		writer.writeSByte(this.atLeastNbMount);
		writer.writeSByte(this.atLeastNbMachine);
		writer.writeInt(this.maxPrice);
	}
}