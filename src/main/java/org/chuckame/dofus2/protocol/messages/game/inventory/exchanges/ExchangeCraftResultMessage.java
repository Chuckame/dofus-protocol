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
public class ExchangeCraftResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5790;
	
	private byte craftResult;
	
	public ExchangeCraftResultMessage() {
	}
	
	public ExchangeCraftResultMessage(byte craftResult) {
		this.craftResult = craftResult;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.craftResult = reader.readSByte();
		if (craftResult < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on craftResult = %s, it doesn't respect the following condition : craftResult < 0", craftResult));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.craftResult);
	}
}