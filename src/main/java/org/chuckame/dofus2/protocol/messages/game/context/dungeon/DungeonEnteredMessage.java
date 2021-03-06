package org.chuckame.dofus2.protocol.messages.game.context.dungeon;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DungeonEnteredMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6152;
	
	private int dungeonId;
	
	public DungeonEnteredMessage() {
	}
	
	public DungeonEnteredMessage(int dungeonId) {
		this.dungeonId = dungeonId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readInt();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.dungeonId);
	}
}