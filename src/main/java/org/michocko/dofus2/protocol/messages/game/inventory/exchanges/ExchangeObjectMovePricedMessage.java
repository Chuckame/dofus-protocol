package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeObjectMoveMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeObjectMovePricedMessage extends ExchangeObjectMoveMessage {
	public static final int MESSAGE_ID = 5514;
	
	private int price;
	
	public ExchangeObjectMovePricedMessage() {
	}
	
	public ExchangeObjectMovePricedMessage(int objectUID, int quantity, int price) {
		super(objectUID, quantity);
		this.price = price;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.price = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.price);
	}
}