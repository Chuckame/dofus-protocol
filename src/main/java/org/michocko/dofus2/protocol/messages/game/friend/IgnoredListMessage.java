package org.michocko.dofus2.protocol.messages.game.friend;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.friend.IgnoredInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		int length = reader.readUShort();
		this.ignoredList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			IgnoredInformations entry = (IgnoredInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.ignoredList.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.ignoredList.size());
		for (IgnoredInformations entry : this.ignoredList)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}