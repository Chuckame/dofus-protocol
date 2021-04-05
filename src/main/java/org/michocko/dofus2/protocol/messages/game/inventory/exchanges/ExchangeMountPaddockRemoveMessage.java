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
public class ExchangeMountPaddockRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6050;
	
	private double mountId;
	
	public ExchangeMountPaddockRemoveMessage() {
	}
	
	public ExchangeMountPaddockRemoveMessage(double mountId) {
		this.mountId = mountId;
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
		this.mountId = reader.readDouble();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.mountId);
	}
}