package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ShowCellMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5612;
	
	private int sourceId;
	private short cellId;
	
	public ShowCellMessage() {
	}
	
	public ShowCellMessage(int sourceId, short cellId) {
		this.sourceId = sourceId;
		this.cellId = cellId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.sourceId = reader.readInt();
		this.cellId = reader.readShort();
		if (cellId < 0 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < 0 || cellId > 559", cellId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.sourceId);
		writer.writeShort(this.cellId);
	}
}