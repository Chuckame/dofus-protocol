package org.chuckame.dofus2.protocol.messages.game.friend;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.friend.IgnoredInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class IgnoredListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5674;
	
	private Collection<IgnoredInformations> ignoredList;
	
	public IgnoredListMessage() {
	}
	
	public IgnoredListMessage(Collection<IgnoredInformations> ignoredList) {
		this.ignoredList = ignoredList;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.ignoredList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			IgnoredInformations entry = ProtocolTypeManager.getInstance().<IgnoredInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.ignoredList.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.ignoredList.size());
		for (IgnoredInformations entry : this.ignoredList)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}