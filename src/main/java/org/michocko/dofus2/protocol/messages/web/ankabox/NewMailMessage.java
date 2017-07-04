package org.michocko.dofus2.protocol.messages.web.ankabox;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.messages.web.ankabox.MailStatusMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class NewMailMessage extends MailStatusMessage {
	public static final int MESSAGE_ID = 6292;
	
	private Collection<Integer> sendersAccountId;
	
	public NewMailMessage() {
	}
	
	public NewMailMessage(short unread, short total, Collection<Integer> sendersAccountId) {
		super(unread, total);
		this.sendersAccountId = sendersAccountId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.sendersAccountId = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			int entry = reader.readInt();
			this.sendersAccountId.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.sendersAccountId.size());
		for (int entry : this.sendersAccountId)
		{
			writer.writeInt(entry);
		}
	}
}