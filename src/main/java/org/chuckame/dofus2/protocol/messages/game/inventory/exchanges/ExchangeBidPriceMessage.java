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
public class ExchangeBidPriceMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5755;
	
	private int genericId;
	private int averagePrice;
	
	public ExchangeBidPriceMessage() {
	}
	
	public ExchangeBidPriceMessage(int genericId, int averagePrice) {
		this.genericId = genericId;
		this.averagePrice = averagePrice;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.genericId = reader.readInt();
		if (genericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on genericId = %s, it doesn't respect the following condition : genericId < 0", genericId));
		this.averagePrice = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.genericId);
		writer.writeInt(this.averagePrice);
	}
}