package org.chuckame.dofus2.protocol.messages.game.context.roleplay.houses;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.amount = reader.readInt();
		if (amount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on amount = %s, it doesn't respect the following condition : amount < 0", amount));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.amount);
	}
}