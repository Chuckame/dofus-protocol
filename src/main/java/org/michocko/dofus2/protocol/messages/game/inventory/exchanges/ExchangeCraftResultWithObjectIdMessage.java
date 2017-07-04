package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeCraftResultMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeCraftResultWithObjectIdMessage extends ExchangeCraftResultMessage {
	public static final int MESSAGE_ID = 6000;
	
	private int objectGenericId;
	
	public ExchangeCraftResultWithObjectIdMessage() {
	}
	
	public ExchangeCraftResultWithObjectIdMessage(byte craftResult, int objectGenericId) {
		super(craftResult);
		this.objectGenericId = objectGenericId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.objectGenericId = reader.readInt();
		if (objectGenericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGenericId = %s, it doesn't respect the following condition : objectGenericId < 0", objectGenericId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.objectGenericId);
	}
}