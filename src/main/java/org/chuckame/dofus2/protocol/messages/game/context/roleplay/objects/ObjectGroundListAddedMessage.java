package org.chuckame.dofus2.protocol.messages.game.context.roleplay.objects;

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
public class ObjectGroundListAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5925;
	
	private Collection<Short> cells;
	private Collection<Integer> referenceIds;
	
	public ObjectGroundListAddedMessage() {
	}
	
	public ObjectGroundListAddedMessage(Collection<Short> cells, Collection<Integer> referenceIds) {
		this.cells = cells;
		this.referenceIds = referenceIds;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.cells = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.cells.add(entry);
		}
		length = reader.readUShort();
		this.referenceIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.referenceIds.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.cells.size());
		for (short entry : this.cells)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.referenceIds.size());
		for (int entry : this.referenceIds)
		{
			writer.writeInt(entry);
		}
	}
}