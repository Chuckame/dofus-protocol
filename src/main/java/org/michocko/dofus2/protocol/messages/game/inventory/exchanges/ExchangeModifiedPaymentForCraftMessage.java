package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemNotInContainer;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeModifiedPaymentForCraftMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5832;
	
	private boolean onlySuccess;
	private ObjectItemNotInContainer object;
	
	public ExchangeModifiedPaymentForCraftMessage() {
	}
	
	public ExchangeModifiedPaymentForCraftMessage(boolean onlySuccess, ObjectItemNotInContainer object) {
		this.onlySuccess = onlySuccess;
		this.object = object;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.onlySuccess = reader.readBoolean();
		this.object = new ObjectItemNotInContainer();
		this.object.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.onlySuccess);
		this.object.serialize(writer);
	}
}