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
public class ExchangeRemovedPaymentForCraftMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6031;
	
	private boolean onlySuccess;
	private int objectUID;
	
	public ExchangeRemovedPaymentForCraftMessage() {
	}
	
	public ExchangeRemovedPaymentForCraftMessage(boolean onlySuccess, int objectUID) {
		this.onlySuccess = onlySuccess;
		this.objectUID = objectUID;
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
		this.onlySuccess = reader.readBoolean();
		this.objectUID = reader.readInt();
		if (objectUID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectUID = %s, it doesn't respect the following condition : objectUID < 0", objectUID));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.onlySuccess);
		writer.writeInt(this.objectUID);
	}
}