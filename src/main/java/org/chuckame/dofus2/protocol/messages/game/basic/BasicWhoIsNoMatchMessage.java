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
public class BasicWhoIsNoMatchMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 179;
	
	private String search;
	
	public BasicWhoIsNoMatchMessage() {
	}
	
	public BasicWhoIsNoMatchMessage(String search) {
		this.search = search;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.search = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.search);
	}
}