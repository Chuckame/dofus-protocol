package org.michocko.dofus2.protocol.messages.common.basic;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicPingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 182;
	
	private boolean quiet;
	
	public BasicPingMessage() {
	}
	
	public BasicPingMessage(boolean quiet) {
		this.quiet = quiet;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.quiet = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.quiet);
	}
}