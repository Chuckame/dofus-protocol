package org.chuckame.dofus2.protocol.messages.updater.parts;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.updater.ContentPart;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PartsListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1502;
	
	private Collection<ContentPart> parts;
	
	public PartsListMessage() {
	}
	
	public PartsListMessage(Collection<ContentPart> parts) {
		this.parts = parts;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.parts = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			ContentPart entry = new ContentPart();
			entry.deserialize(reader);
			this.parts.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.parts.size());
		for (ContentPart entry : this.parts)
		{
			entry.serialize(writer);
		}
	}
}