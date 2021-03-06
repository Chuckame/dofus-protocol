package org.chuckame.dofus2.protocol.messages.game.interactive;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.interactive.StatedElement;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.statedElement = new StatedElement();
		this.statedElement.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.statedElement.serialize(writer);
	}
}