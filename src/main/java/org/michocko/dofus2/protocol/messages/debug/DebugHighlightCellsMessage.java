package org.michocko.dofus2.protocol.messages.debug;

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
public class DebugHighlightCellsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 2001;
	
	private int color;
	private Collection<Short> cells;
	
	public DebugHighlightCellsMessage() {
	}
	
	public DebugHighlightCellsMessage(int color, Collection<Short> cells) {
		this.color = color;
		this.cells = cells;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.color = reader.readInt();
		int length = reader.readUShort();
		this.cells = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.cells.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.color);
		writer.writeUShort(this.cells.size());
		for (short entry : this.cells)
		{
			writer.writeShort(entry);
		}
	}
}