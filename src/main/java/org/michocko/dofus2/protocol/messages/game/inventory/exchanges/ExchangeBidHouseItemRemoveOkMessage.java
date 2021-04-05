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
public class ExchangeBidHouseItemRemoveOkMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5946;
	
	private int sellerId;
	
	public ExchangeBidHouseItemRemoveOkMessage() {
	}
	
	public ExchangeBidHouseItemRemoveOkMessage(int sellerId) {
		this.sellerId = sellerId;
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
		this.sellerId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.sellerId);
	}
}