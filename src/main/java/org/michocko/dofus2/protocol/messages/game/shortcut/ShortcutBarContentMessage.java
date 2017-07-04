package org.michocko.dofus2.protocol.messages.game.shortcut;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.shortcut.Shortcut;

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
public class ShortcutBarContentMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6231;
	
	private byte barType;
	private Collection<Shortcut> shortcuts;
	
	public ShortcutBarContentMessage() {
	}
	
	public ShortcutBarContentMessage(byte barType, Collection<Shortcut> shortcuts) {
		this.barType = barType;
		this.shortcuts = shortcuts;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.barType = reader.readSByte();
		if (barType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on barType = %s, it doesn't respect the following condition : barType < 0", barType));
		int length = reader.readUShort();
		this.shortcuts = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			Shortcut entry = ProtocolTypeManager.getInstance().<Shortcut>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.shortcuts.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.barType);
		writer.writeUShort(this.shortcuts.size());
		for (Shortcut entry : this.shortcuts)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}