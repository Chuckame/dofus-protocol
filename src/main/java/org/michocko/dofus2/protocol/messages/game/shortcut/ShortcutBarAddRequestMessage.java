package org.michocko.dofus2.protocol.messages.game.shortcut;

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
public class ShortcutBarAddRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6225;
	
	private byte barType;
	private Shortcut shortcut;
	
	public ShortcutBarAddRequestMessage() {
	}
	
	public ShortcutBarAddRequestMessage(byte barType, Shortcut shortcut) {
		this.barType = barType;
		this.shortcut = shortcut;
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
		this.barType = reader.readSByte();
		if (barType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on barType = %s, it doesn't respect the following condition : barType < 0", barType));
		this.shortcut = (Shortcut) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.shortcut.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.barType);
		writer.writeShort(this.shortcut.getNetworkTypeId());
		this.shortcut.serialize(writer);
	}
}