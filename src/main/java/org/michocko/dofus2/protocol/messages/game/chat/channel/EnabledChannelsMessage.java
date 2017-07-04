package org.michocko.dofus2.protocol.messages.game.chat.channel;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class EnabledChannelsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 892;
	
	private Collection<Byte> channels;
	private Collection<Byte> disallowed;
	
	public EnabledChannelsMessage() {
	}
	
	public EnabledChannelsMessage(Collection<Byte> channels, Collection<Byte> disallowed) {
		this.channels = channels;
		this.disallowed = disallowed;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.channels = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.channels.add(entry);
		}
		length = reader.readUShort();
		this.disallowed = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			byte entry = reader.readSByte();
			this.disallowed.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.channels.size());
		for (byte entry : this.channels)
		{
			writer.writeSByte(entry);
		}
		writer.writeUShort(this.disallowed.size());
		for (byte entry : this.disallowed)
		{
			writer.writeSByte(entry);
		}
	}
}