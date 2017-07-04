package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.party.DungeonPartyFinderPlayer;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DungeonPartyFinderRoomContentMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6247;
	
	private short dungeonId;
	private Collection<DungeonPartyFinderPlayer> players;
	
	public DungeonPartyFinderRoomContentMessage() {
	}
	
	public DungeonPartyFinderRoomContentMessage(short dungeonId, Collection<DungeonPartyFinderPlayer> players) {
		this.dungeonId = dungeonId;
		this.players = players;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		int length = reader.readUShort();
		this.players = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			DungeonPartyFinderPlayer entry = new DungeonPartyFinderPlayer();
			entry.deserialize(reader);
			this.players.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
		writer.writeUShort(this.players.size());
		for (DungeonPartyFinderPlayer entry : this.players)
		{
			entry.serialize(writer);
		}
	}
}