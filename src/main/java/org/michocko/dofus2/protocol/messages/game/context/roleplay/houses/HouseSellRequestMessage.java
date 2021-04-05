package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseSellRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5697;
	
	private int amount;
	
	public HouseSellRequestMessage() {
	}
	
	public HouseSellRequestMessage(int amount) {
		this.amount = amount;
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
		this.amount = reader.readInt();
		if (amount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on amount = %s, it doesn't respect the following condition : amount < 0", amount));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.amount);
	}
}