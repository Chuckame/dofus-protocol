package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DungeonPartyFinderAvailableDungeonsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6242;
	
	private Collection<Short> dungeonIds;
	
	public DungeonPartyFinderAvailableDungeonsMessage() {
	}
	
	public DungeonPartyFinderAvailableDungeonsMessage(Collection<Short> dungeonIds) {
		this.dungeonIds = dungeonIds;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.dungeonIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.dungeonIds.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.dungeonIds.size());
		for (short entry : this.dungeonIds)
		{
			writer.writeShort(entry);
		}
	}
}