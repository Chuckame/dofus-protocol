package org.michocko.dofus2.protocol.messages.game.context;

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
public class GameContextRemoveMultipleElementsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 252;
	
	private Collection<Integer> id;
	
	public GameContextRemoveMultipleElementsMessage() {
	}
	
	public GameContextRemoveMultipleElementsMessage(Collection<Integer> id) {
		this.id = id;
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
		this.id = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.id.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.id.size());
		for (int entry : this.id)
		{
			writer.writeInt(entry);
		}
	}
}