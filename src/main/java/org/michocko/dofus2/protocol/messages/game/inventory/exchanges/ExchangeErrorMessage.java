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
public class ExchangeErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5513;
	
	private byte errorType;
	
	public ExchangeErrorMessage() {
	}
	
	public ExchangeErrorMessage(byte errorType) {
		this.errorType = errorType;
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
		this.errorType = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.errorType);
	}
}