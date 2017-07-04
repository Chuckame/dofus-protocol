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
public class ExchangeGoldPaymentForCraftMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5833;
	
	private boolean onlySuccess;
	private int goldSum;
	
	public ExchangeGoldPaymentForCraftMessage() {
	}
	
	public ExchangeGoldPaymentForCraftMessage(boolean onlySuccess, int goldSum) {
		this.onlySuccess = onlySuccess;
		this.goldSum = goldSum;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.onlySuccess = reader.readBoolean();
		this.goldSum = reader.readInt();
		if (goldSum < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on goldSum = %s, it doesn't respect the following condition : goldSum < 0", goldSum));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.onlySuccess);
		writer.writeInt(this.goldSum);
	}
}