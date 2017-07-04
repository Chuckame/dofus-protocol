package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountRidingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5967;
	
	private boolean isRiding;
	
	public MountRidingMessage() {
	}
	
	public MountRidingMessage(boolean isRiding) {
		this.isRiding = isRiding;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.isRiding = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.isRiding);
	}
}