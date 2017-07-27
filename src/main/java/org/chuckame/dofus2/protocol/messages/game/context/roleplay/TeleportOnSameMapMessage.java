package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TeleportOnSameMapMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6048;
	
	private int targetId;
	private short cellId;
	
	public TeleportOnSameMapMessage() {
	}
	
	public TeleportOnSameMapMessage(int targetId, short cellId) {
		this.targetId = targetId;
		this.cellId = cellId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.targetId = reader.readInt();
		this.cellId = reader.readShort();
		if (cellId < 0 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < 0 || cellId > 559", cellId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.targetId);
		writer.writeShort(this.cellId);
	}
}