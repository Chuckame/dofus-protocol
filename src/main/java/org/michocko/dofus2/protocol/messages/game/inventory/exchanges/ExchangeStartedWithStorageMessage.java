package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeStartedMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeStartedWithStorageMessage extends ExchangeStartedMessage {
	public static final int MESSAGE_ID = 6236;
	
	private int storageMaxSlot;
	
	public ExchangeStartedWithStorageMessage() {
	}
	
	public ExchangeStartedWithStorageMessage(byte exchangeType, int storageMaxSlot) {
		super(exchangeType);
		this.storageMaxSlot = storageMaxSlot;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.storageMaxSlot = reader.readInt();
		if (storageMaxSlot < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on storageMaxSlot = %s, it doesn't respect the following condition : storageMaxSlot < 0", storageMaxSlot));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.storageMaxSlot);
	}
}