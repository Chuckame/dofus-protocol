package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.ActorOrientation;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameMapChangeOrientationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 946;
	
	private ActorOrientation orientation;
	
	public GameMapChangeOrientationMessage() {
	}
	
	public GameMapChangeOrientationMessage(ActorOrientation orientation) {
		this.orientation = orientation;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.orientation = new ActorOrientation();
		this.orientation.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.orientation.serialize(writer);
	}
}