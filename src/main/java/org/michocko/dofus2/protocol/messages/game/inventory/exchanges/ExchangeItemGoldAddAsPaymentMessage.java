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
public class ExchangeItemGoldAddAsPaymentMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5770;
	
	private byte paymentType;
	private int quantity;
	
	public ExchangeItemGoldAddAsPaymentMessage() {
	}
	
	public ExchangeItemGoldAddAsPaymentMessage(byte paymentType, int quantity) {
		this.paymentType = paymentType;
		this.quantity = quantity;
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
		this.paymentType = reader.readSByte();
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.paymentType);
		writer.writeInt(this.quantity);
	}
}