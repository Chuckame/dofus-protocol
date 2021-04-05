package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildCreationStartedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5920;
	
	
	public GuildCreationStartedMessage() {
	}
	
	
	@Override
	public boolean containsNoField() {
		return true;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
	}
	
	@Override
	public void serialize(IDataWriter writer) {
	}
}