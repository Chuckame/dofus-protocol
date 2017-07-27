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
public class BasicWhoAmIRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5664;
	
	private boolean verbose;
	
	public BasicWhoAmIRequestMessage() {
	}
	
	public BasicWhoAmIRequestMessage(boolean verbose) {
		this.verbose = verbose;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.verbose = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.verbose);
	}
}