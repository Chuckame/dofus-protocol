package org.michocko.dofus2.protocol.messages.game.interactive;

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
public class StatedElementUpdatedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5709;
	
	private StatedElement statedElement;
	
	public StatedElementUpdatedMessage() {
	}
	
	public StatedElementUpdatedMessage(StatedElement statedElement) {
		this.statedElement = statedElement;
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
		this.statedElement = new StatedElement();
		this.statedElement.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.statedElement.serialize(writer);
	}
}