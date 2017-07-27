package org.chuckame.dofus2.protocol.messages.game.context;

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
public class GameContextRemoveMultipleElementsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 252;
	
	private Collection<Integer> id;
	
	public GameContextRemoveMultipleElementsMessage() {
	}
	
	public GameContextRemoveMultipleElementsMessage(Collection<Integer> id) {
		this.id = id;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.id = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.id.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.id.size());
		for (int entry : this.id)
		{
			writer.writeInt(entry);
		}
	}
}