package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeObjectMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeKamaModifiedMessage extends ExchangeObjectMessage {
	public static final int MESSAGE_ID = 5521;
	
	private int quantity;
	
	public ExchangeKamaModifiedMessage() {
	}
	
	public ExchangeKamaModifiedMessage(boolean remote, int quantity) {
		super(remote);
		this.quantity = quantity;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.quantity);
	}
}