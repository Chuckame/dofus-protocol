package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItem;
import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeObjectMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeObjectAddedMessage extends ExchangeObjectMessage {
	public static final int MESSAGE_ID = 5516;
	
	private ObjectItem object;
	
	public ExchangeObjectAddedMessage() {
	}
	
	public ExchangeObjectAddedMessage(boolean remote, ObjectItem object) {
		super(remote);
		this.object = object;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.object = new ObjectItem();
		this.object.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.object.serialize(writer);
	}
}