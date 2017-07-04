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
public class DungeonPartyFinderRoomContentUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6250;
	
	private short dungeonId;
	private Collection<DungeonPartyFinderPlayer> addedPlayers;
	private Collection<Integer> removedPlayersIds;
	
	public DungeonPartyFinderRoomContentUpdateMessage() {
	}
	
	public DungeonPartyFinderRoomContentUpdateMessage(short dungeonId, Collection<DungeonPartyFinderPlayer> addedPlayers, Collection<Integer> removedPlayersIds) {
		this.dungeonId = dungeonId;
		this.addedPlayers = addedPlayers;
		this.removedPlayersIds = removedPlayersIds;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dungeonId = reader.readShort();
		if (dungeonId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dungeonId = %s, it doesn't respect the following condition : dungeonId < 0", dungeonId));
		int length = reader.readUShort();
		this.addedPlayers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			DungeonPartyFinderPlayer entry = new DungeonPartyFinderPlayer();
			entry.deserialize(reader);
			this.addedPlayers.add(entry);
		}
		length = reader.readUShort();
		this.removedPlayersIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.removedPlayersIds.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.dungeonId);
		writer.writeUShort(this.addedPlayers.size());
		for (DungeonPartyFinderPlayer entry : this.addedPlayers)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.removedPlayersIds.size());
		for (int entry : this.removedPlayersIds)
		{
			writer.writeInt(entry);
		}
	}
}