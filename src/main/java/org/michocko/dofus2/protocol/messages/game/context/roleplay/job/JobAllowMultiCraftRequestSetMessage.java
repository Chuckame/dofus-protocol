package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobAllowMultiCraftRequestSetMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5749;
	
	private boolean enabled;
	
	public JobAllowMultiCraftRequestSetMessage() {
	}
	
	public JobAllowMultiCraftRequestSetMessage(boolean enabled) {
		this.enabled = enabled;
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
		this.enabled = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enabled);
	}
}