package org.chuckame.dofus2.protocol.messages.game.shortcut;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ShortcutBarRemoveRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6228;
	
	private byte barType;
	private int slot;
	
	public ShortcutBarRemoveRequestMessage() {
	}
	
	public ShortcutBarRemoveRequestMessage(byte barType, int slot) {
		this.barType = barType;
		this.slot = slot;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.barType = reader.readSByte();
		if (barType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on barType = %s, it doesn't respect the following condition : barType < 0", barType));
		this.slot = reader.readInt();
		if (slot < 0 || slot > 99)
			throw new IllegalArgumentException(String.format("Forbidden value on slot = %s, it doesn't respect the following condition : slot < 0 || slot > 99", slot));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.barType);
		writer.writeInt(this.slot);
	}
}