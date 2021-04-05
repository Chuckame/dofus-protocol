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
		this.genericId = reader.readInt();
		if (genericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on genericId = %s, it doesn't respect the following condition : genericId < 0", genericId));
		this.averagePrice = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.genericId);
		writer.writeInt(this.averagePrice);
	}
}