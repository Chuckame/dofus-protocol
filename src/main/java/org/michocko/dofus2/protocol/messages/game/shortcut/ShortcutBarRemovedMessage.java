package org.michocko.dofus2.protocol.messages.game.shortcut;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ShortcutBarRemovedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6224;
	
	private byte barType;
	private int slot;
	
	public ShortcutBarRemovedMessage() {
	}
	
	public ShortcutBarRemovedMessage(byte barType, int slot) {
		this.barType = barType;
		this.slot = slot;
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
		this.slot = reader.readInt();
		if (slot < 0 || slot > 99)
			throw new IllegalArgumentException(String.format("Forbidden value on slot = %s, it doesn't respect the following condition : slot < 0 || slot > 99", slot));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.barType);
		writer.writeInt(this.slot);
	}
}