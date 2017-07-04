package org.michocko.dofus2.protocol.messages.game.interactive;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.interactive.StatedElement;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StatedMapUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5716;
	
	private Collection<StatedElement> statedElements;
	
	public StatedMapUpdateMessage() {
	}
	
	public StatedMapUpdateMessage(Collection<StatedElement> statedElements) {
		this.statedElements = statedElements;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.statedElements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			StatedElement entry = new StatedElement();
			entry.deserialize(reader);
			this.statedElements.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.statedElements.size());
		for (StatedElement entry : this.statedElements)
		{
			entry.serialize(writer);
		}
	}
}