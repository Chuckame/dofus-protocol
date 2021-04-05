package org.michocko.dofus2.protocol.messages.game.subscriber;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.active = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.active);
	}
}