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
public class PaddockRemoveItemRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5958;
	
	private short cellId;
	
	public PaddockRemoveItemRequestMessage() {
	}
	
	public PaddockRemoveItemRequestMessage(short cellId) {
		this.cellId = cellId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.cellId = reader.readShort();
		if (cellId < 0 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < 0 || cellId > 559", cellId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.cellId);
	}
}