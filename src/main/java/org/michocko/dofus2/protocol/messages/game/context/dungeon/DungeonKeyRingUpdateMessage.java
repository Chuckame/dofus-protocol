package org.michocko.dofus2.protocol.messages.game.context.dungeon;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DungeonKeyRingUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6296;
	
	private short dungeonId;
	private boolean available;
	
	public DungeonKeyRingUpdateMessage() {
	}
	
	public DungeonKeyRingUpdateMessage(short dungeonId, boolean available) {
		this.dungeonId = dungeonId;
		this.available = available;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		this.available = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
		writer.writeBoolean(this.available);
	}
}