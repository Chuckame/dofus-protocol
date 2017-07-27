package org.chuckame.dofus2.protocol.messages.game.basic;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
	}
	
	public void serialize(IDataWriter writer) {
	}
}