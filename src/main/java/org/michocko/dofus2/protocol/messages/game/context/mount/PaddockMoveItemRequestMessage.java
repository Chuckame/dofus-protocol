package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PaddockMoveItemRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6052;
	
	private short oldCellId;
	private short newCellId;
	
	public PaddockMoveItemRequestMessage() {
	}
	
	public PaddockMoveItemRequestMessage(short oldCellId, short newCellId) {
		this.oldCellId = oldCellId;
		this.newCellId = newCellId;
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
		this.oldCellId = reader.readShort();
		if (oldCellId < 0 || oldCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on oldCellId = %s, it doesn't respect the following condition : oldCellId < 0 || oldCellId > 559", oldCellId));
		this.newCellId = reader.readShort();
		if (newCellId < 0 || newCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on newCellId = %s, it doesn't respect the following condition : newCellId < 0 || newCellId > 559", newCellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.oldCellId);
		writer.writeShort(this.newCellId);
	}
}