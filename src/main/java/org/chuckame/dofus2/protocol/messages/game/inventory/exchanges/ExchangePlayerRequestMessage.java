package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.exchanges.ExchangeRequestMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangePlayerRequestMessage extends ExchangeRequestMessage {
	public static final int MESSAGE_ID = 5773;
	
	private int target;
	
	public ExchangePlayerRequestMessage() {
	}
	
	public ExchangePlayerRequestMessage(byte exchangeType, int target) {
		super(exchangeType);
		this.target = target;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.target = reader.readInt();
		if (target < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on target = %s, it doesn't respect the following condition : target < 0", target));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.target);
	}
}