package org.michocko.dofus2.protocol.messages.secure;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class TrustStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6267;
	
	private boolean trusted;
	
	public TrustStatusMessage() {
	}
	
	public TrustStatusMessage(boolean trusted) {
		this.trusted = trusted;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.trusted = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.trusted);
	}
}