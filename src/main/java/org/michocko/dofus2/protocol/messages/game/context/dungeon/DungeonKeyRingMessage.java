package org.michocko.dofus2.protocol.messages.game.context.dungeon;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
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
	
	@Override
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