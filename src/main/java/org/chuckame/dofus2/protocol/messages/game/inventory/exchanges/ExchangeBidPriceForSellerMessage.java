package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.exchanges.ExchangeBidPriceMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeBidPriceForSellerMessage extends ExchangeBidPriceMessage {
	public static final int MESSAGE_ID = 6464;
	
	private boolean allIdentical;
	private Collection<Integer> minimalPrices;
	
	public ExchangeBidPriceForSellerMessage() {
	}
	
	public ExchangeBidPriceForSellerMessage(int genericId, int averagePrice, boolean allIdentical, Collection<Integer> minimalPrices) {
		super(genericId, averagePrice);
		this.allIdentical = allIdentical;
		this.minimalPrices = minimalPrices;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allIdentical = reader.readBoolean();
		int length = reader.readUShort();
		this.minimalPrices = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.minimalPrices.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeBoolean(this.allIdentical);
		writer.writeUShort(this.minimalPrices.size());
		for (int entry : this.minimalPrices)
		{
			writer.writeInt(entry);
		}
	}
}