package org.chuckame.dofus2.protocol.messages.game.subscriber;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SubscriptionZoneMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5573;
	
	private boolean active;
	
	public SubscriptionZoneMessage() {
	}
	
	public SubscriptionZoneMessage(boolean active) {
		this.active = active;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.active = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.active);
	}
}