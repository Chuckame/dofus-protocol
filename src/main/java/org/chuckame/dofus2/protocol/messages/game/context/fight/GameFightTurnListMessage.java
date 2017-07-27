package org.chuckame.dofus2.protocol.messages.game.context.fight;

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
public class GameFightTurnListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 713;
	
	private Collection<Integer> ids;
	private Collection<Integer> deadsIds;
	
	public GameFightTurnListMessage() {
	}
	
	public GameFightTurnListMessage(Collection<Integer> ids, Collection<Integer> deadsIds) {
		this.ids = ids;
		this.deadsIds = deadsIds;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.ids = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.ids.add(entry);
		}
		length = reader.readUShort();
		this.deadsIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.deadsIds.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.ids.size());
		for (int entry : this.ids)
		{
			writer.writeInt(entry);
		}
		writer.writeUShort(this.deadsIds.size());
		for (int entry : this.deadsIds)
		{
			writer.writeInt(entry);
		}
	}
}