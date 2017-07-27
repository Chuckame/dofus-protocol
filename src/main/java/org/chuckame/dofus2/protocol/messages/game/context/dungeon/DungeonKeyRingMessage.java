package org.chuckame.dofus2.protocol.messages.game.context.dungeon;

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
public class DungeonKeyRingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6299;
	
	private Collection<Short> availables;
	private Collection<Short> unavailables;
	
	public DungeonKeyRingMessage() {
	}
	
	public DungeonKeyRingMessage(Collection<Short> availables, Collection<Short> unavailables) {
		this.availables = availables;
		this.unavailables = unavailables;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.availables = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.availables.add(entry);
		}
		length = reader.readUShort();
		this.unavailables = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.unavailables.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.availables.size());
		for (short entry : this.availables)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.unavailables.size());
		for (short entry : this.unavailables)
		{
			writer.writeShort(entry);
		}
	}
}