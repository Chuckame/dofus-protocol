package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.inventory.exchanges.ExchangeCraftResultMessage;
import org.chuckame.dofus2.protocol.types.game.data.items.ObjectItemNotInContainer;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeCraftResultWithObjectDescMessage extends ExchangeCraftResultMessage {
	public static final int MESSAGE_ID = 5999;
	
	private ObjectItemNotInContainer objectInfo;
	
	public ExchangeCraftResultWithObjectDescMessage() {
	}
	
	public ExchangeCraftResultWithObjectDescMessage(byte craftResult, ObjectItemNotInContainer objectInfo) {
		super(craftResult);
		this.objectInfo = objectInfo;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.objectInfo = new ObjectItemNotInContainer();
		this.objectInfo.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.objectInfo.serialize(writer);
	}
}