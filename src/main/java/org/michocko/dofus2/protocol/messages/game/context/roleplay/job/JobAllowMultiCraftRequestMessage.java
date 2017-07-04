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
public class JobAllowMultiCraftRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5748;
	
	private boolean enabled;
	
	public JobAllowMultiCraftRequestMessage() {
	}
	
	public JobAllowMultiCraftRequestMessage(boolean enabled) {
		this.enabled = enabled;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.enabled = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enabled);
	}
}