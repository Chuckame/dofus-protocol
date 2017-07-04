package org.michocko.dofus2.protocol.messages.game.interactive;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.interactive.InteractiveElement;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InteractiveMapUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5002;
	
	private Collection<InteractiveElement> interactiveElements;
	
	public InteractiveMapUpdateMessage() {
	}
	
	public InteractiveMapUpdateMessage(Collection<InteractiveElement> interactiveElements) {
		this.interactiveElements = interactiveElements;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.interactiveElements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			InteractiveElement entry = ProtocolTypeManager.getInstance().<InteractiveElement>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.interactiveElements.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.interactiveElements.size());
		for (InteractiveElement entry : this.interactiveElements)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}