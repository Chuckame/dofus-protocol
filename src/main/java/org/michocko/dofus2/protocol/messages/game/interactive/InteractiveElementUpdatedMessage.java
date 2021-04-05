package org.michocko.dofus2.protocol.messages.game.interactive;

import org.michocko.dofus2.protocol.types.game.interactive.InteractiveElement;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InteractiveElementUpdatedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5708;
	
	private InteractiveElement interactiveElement;
	
	public InteractiveElementUpdatedMessage() {
	}
	
	public InteractiveElementUpdatedMessage(InteractiveElement interactiveElement) {
		this.interactiveElement = interactiveElement;
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
		this.interactiveElement = new InteractiveElement();
		this.interactiveElement.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.interactiveElement.serialize(writer);
	}
}