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
public class ExchangeReplyTaxVendorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5787;
	
	private int objectValue;
	private int totalTaxValue;
	
	public ExchangeReplyTaxVendorMessage() {
	}
	
	public ExchangeReplyTaxVendorMessage(int objectValue, int totalTaxValue) {
		this.objectValue = objectValue;
		this.totalTaxValue = totalTaxValue;
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
		this.objectValue = reader.readInt();
		if (objectValue < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectValue = %s, it doesn't respect the following condition : objectValue < 0", objectValue));
		this.totalTaxValue = reader.readInt();
		if (totalTaxValue < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on totalTaxValue = %s, it doesn't respect the following condition : totalTaxValue < 0", totalTaxValue));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objectValue);
		writer.writeInt(this.totalTaxValue);
	}
}