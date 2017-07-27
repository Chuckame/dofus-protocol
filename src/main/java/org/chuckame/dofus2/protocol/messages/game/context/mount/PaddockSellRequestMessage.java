package org.chuckame.dofus2.protocol.messages.game.context.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PaddockSellRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5953;
	
	private int price;
	
	public PaddockSellRequestMessage() {
	}
	
	public PaddockSellRequestMessage(int price) {
		this.price = price;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.price = reader.readInt();
		if (price < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0", price));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.price);
	}
}