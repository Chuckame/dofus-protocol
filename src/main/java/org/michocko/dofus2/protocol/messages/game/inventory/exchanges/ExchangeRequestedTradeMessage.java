package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeRequestedMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeRequestedTradeMessage extends ExchangeRequestedMessage {
	public static final int MESSAGE_ID = 5523;
	
	private int source;
	private int target;
	
	public ExchangeRequestedTradeMessage() {
	}
	
	public ExchangeRequestedTradeMessage(byte exchangeType, int source, int target) {
		super(exchangeType);
		this.source = source;
		this.target = target;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.source = reader.readInt();
		if (source < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on source = %s, it doesn't respect the following condition : source < 0", source));
		this.target = reader.readInt();
		if (target < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on target = %s, it doesn't respect the following condition : target < 0", target));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.source);
		writer.writeInt(this.target);
	}
}