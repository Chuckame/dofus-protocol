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
public class ExchangeCraftSlotCountIncreasedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6125;
	
	private byte newMaxSlot;
	
	public ExchangeCraftSlotCountIncreasedMessage() {
	}
	
	public ExchangeCraftSlotCountIncreasedMessage(byte newMaxSlot) {
		this.newMaxSlot = newMaxSlot;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.newMaxSlot = reader.readSByte();
		if (newMaxSlot < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on newMaxSlot = %s, it doesn't respect the following condition : newMaxSlot < 0", newMaxSlot));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.newMaxSlot);
	}
}