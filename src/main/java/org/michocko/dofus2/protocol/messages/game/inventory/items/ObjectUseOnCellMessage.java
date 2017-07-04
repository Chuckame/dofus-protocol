package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.protocol.messages.game.inventory.items.ObjectUseMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ObjectUseOnCellMessage extends ObjectUseMessage {
	public static final int MESSAGE_ID = 3013;
	
	private short cells;
	
	public ObjectUseOnCellMessage() {
	}
	
	public ObjectUseOnCellMessage(int objectUID, short cells) {
		super(objectUID);
		this.cells = cells;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.cells = reader.readShort();
		if (cells < 0 || cells > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cells = %s, it doesn't respect the following condition : cells < 0 || cells > 559", cells));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.cells);
	}
}