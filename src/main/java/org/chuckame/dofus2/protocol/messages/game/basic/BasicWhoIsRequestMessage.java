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
public class BasicWhoIsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 181;
	
	private boolean verbose;
	private String search;
	
	public BasicWhoIsRequestMessage() {
	}
	
	public BasicWhoIsRequestMessage(boolean verbose, String search) {
		this.verbose = verbose;
		this.search = search;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.verbose = reader.readBoolean();
		this.search = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.verbose);
		writer.writeUTF(this.search);
	}
}