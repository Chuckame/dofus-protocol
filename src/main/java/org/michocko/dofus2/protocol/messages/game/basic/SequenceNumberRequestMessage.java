package org.michocko.dofus2.protocol.messages.game.basic;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SequenceNumberRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6316;
	
	
	public SequenceNumberRequestMessage() {
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