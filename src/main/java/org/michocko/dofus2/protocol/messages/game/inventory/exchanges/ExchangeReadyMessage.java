package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeReadyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5511;
	
	private boolean ready;
	private short step;
	
	public ExchangeReadyMessage() {
	}
	
	public ExchangeReadyMessage(boolean ready, short step) {
		this.ready = ready;
		this.step = step;
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
		this.ready = reader.readBoolean();
		this.step = reader.readShort();
		if (step < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on step = %s, it doesn't respect the following condition : step < 0", step));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.ready);
		writer.writeShort(this.step);
	}
}