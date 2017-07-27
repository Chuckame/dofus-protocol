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
public class GameMapMovementCancelMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 953;
	
	private short cellId;
	
	public GameMapMovementCancelMessage() {
	}
	
	public GameMapMovementCancelMessage(short cellId) {
		this.cellId = cellId;
	}
	
	public int getProtocolId() {
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