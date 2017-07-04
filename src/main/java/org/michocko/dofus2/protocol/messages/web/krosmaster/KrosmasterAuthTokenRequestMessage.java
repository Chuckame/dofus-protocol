package org.michocko.dofus2.protocol.messages.web.krosmaster;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class KrosmasterAuthTokenRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6346;
	
	
	public KrosmasterAuthTokenRequestMessage() {
	}
	
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
	}
	
	public void serialize(IDataWriter writer) {
	}
}