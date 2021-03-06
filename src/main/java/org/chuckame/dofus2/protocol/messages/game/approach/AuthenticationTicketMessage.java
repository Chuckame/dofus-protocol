package org.chuckame.dofus2.protocol.messages.game.approach;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AuthenticationTicketMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 110;
	
	private String lang;
	private String ticket;
	
	public AuthenticationTicketMessage() {
	}
	
	public AuthenticationTicketMessage(String lang, String ticket) {
		this.lang = lang;
		this.ticket = ticket;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.lang = reader.readUTF();
		this.ticket = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.lang);
		writer.writeUTF(this.ticket);
	}
}