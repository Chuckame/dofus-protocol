package org.michocko.dofus2.protocol.messages.web.ankabox;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MailStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6275;
	
	private short unread;
	private short total;
	
	public MailStatusMessage() {
	}
	
	public MailStatusMessage(short unread, short total) {
		this.unread = unread;
		this.total = total;
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
		this.unread = reader.readShort();
		if (unread < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on unread = %s, it doesn't respect the following condition : unread < 0", unread));
		this.total = reader.readShort();
		if (total < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on total = %s, it doesn't respect the following condition : total < 0", total));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.unread);
		writer.writeShort(this.total);
	}
}