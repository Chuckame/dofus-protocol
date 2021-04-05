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
public class ExchangeBidHousePriceMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5805;
	
	private int genId;
	
	public ExchangeBidHousePriceMessage() {
	}
	
	public ExchangeBidHousePriceMessage(int genId) {
		this.genId = genId;
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
		this.genId = reader.readInt();
		if (genId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on genId = %s, it doesn't respect the following condition : genId < 0", genId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.genId);
	}
}