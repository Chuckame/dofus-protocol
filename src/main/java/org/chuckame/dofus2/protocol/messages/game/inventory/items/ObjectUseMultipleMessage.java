package org.chuckame.dofus2.protocol.messages.game.inventory.items;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.items.ObjectUseMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ObjectUseMultipleMessage extends ObjectUseMessage {
	public static final int MESSAGE_ID = 6234;
	
	private int quantity;
	
	public ObjectUseMultipleMessage() {
	}
	
	public ObjectUseMultipleMessage(int objectUID, int quantity) {
		super(objectUID);
		this.quantity = quantity;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.quantity);
	}
}