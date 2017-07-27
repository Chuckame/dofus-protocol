package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DungeonPartyFinderListenErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6248;
	
	private short dungeonId;
	
	public DungeonPartyFinderListenErrorMessage() {
	}
	
	public DungeonPartyFinderListenErrorMessage(short dungeonId) {
		this.dungeonId = dungeonId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
	}
}