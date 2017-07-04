package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.types.game.data.items.ObjectItemNotInContainer;
import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeCraftResultWithObjectDescMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeCraftResultMagicWithObjectDescMessage extends ExchangeCraftResultWithObjectDescMessage {
	public static final int MESSAGE_ID = 6188;
	
	private byte magicPoolStatus;
	
	public ExchangeCraftResultMagicWithObjectDescMessage() {
	}
	
	public ExchangeCraftResultMagicWithObjectDescMessage(byte craftResult, ObjectItemNotInContainer objectInfo, byte magicPoolStatus) {
		super(craftResult, objectInfo);
		this.magicPoolStatus = magicPoolStatus;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.magicPoolStatus = reader.readSByte();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.magicPoolStatus);
	}
}