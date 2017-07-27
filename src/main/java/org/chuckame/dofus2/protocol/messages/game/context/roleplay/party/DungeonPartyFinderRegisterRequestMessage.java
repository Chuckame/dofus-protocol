package org.chuckame.dofus2.protocol.messages.game.context.roleplay.party;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DungeonPartyFinderRegisterRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6249;
	
	private Collection<Short> dungeonIds;
	
	public DungeonPartyFinderRegisterRequestMessage() {
	}
	
	public DungeonPartyFinderRegisterRequestMessage(Collection<Short> dungeonIds) {
		this.dungeonIds = dungeonIds;
	}
	
	public int getProtocolId() {
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