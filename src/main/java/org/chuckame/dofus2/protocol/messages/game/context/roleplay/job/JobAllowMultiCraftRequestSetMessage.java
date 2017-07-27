package org.chuckame.dofus2.protocol.messages.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.enabled = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enabled);
	}
}