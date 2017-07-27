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
public class ExchangeRequestedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5522;
	
	private byte exchangeType;
	
	public ExchangeRequestedMessage() {
	}
	
	public ExchangeRequestedMessage(byte exchangeType) {
		this.exchangeType = exchangeType;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.exchangeType = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.exchangeType);
	}
}