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
public class ExchangeItemAutoCraftStopedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5810;
	
	private byte reason;
	
	public ExchangeItemAutoCraftStopedMessage() {
	}
	
	public ExchangeItemAutoCraftStopedMessage(byte reason) {
		this.reason = reason;
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
		this.reason = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.reason);
	}
}