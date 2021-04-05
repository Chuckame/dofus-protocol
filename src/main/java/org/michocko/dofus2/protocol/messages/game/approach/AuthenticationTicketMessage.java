package org.michocko.dofus2.protocol.messages.game.approach;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.lang = reader.readUTF();
		this.ticket = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.lang);
		writer.writeUTF(this.ticket);
	}
}