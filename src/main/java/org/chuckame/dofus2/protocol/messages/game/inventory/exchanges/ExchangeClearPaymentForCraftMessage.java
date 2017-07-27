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
public class ExchangeClearPaymentForCraftMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6145;
	
	private byte paymentType;
	
	public ExchangeClearPaymentForCraftMessage() {
	}
	
	public ExchangeClearPaymentForCraftMessage(byte paymentType) {
		this.paymentType = paymentType;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.paymentType = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.paymentType);
	}
}