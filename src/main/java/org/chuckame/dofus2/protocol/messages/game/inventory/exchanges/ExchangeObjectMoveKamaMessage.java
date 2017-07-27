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
public class ExchangeObjectMoveKamaMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5520;
	
	private int quantity;
	
	public ExchangeObjectMoveKamaMessage() {
	}
	
	public ExchangeObjectMoveKamaMessage(int quantity) {
		this.quantity = quantity;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.quantity = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.quantity);
	}
}