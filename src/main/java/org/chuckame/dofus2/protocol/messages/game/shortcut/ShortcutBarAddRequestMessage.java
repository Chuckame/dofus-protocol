package org.chuckame.dofus2.protocol.messages.game.shortcut;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.shortcut.Shortcut;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.barType = reader.readSByte();
		if (barType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on barType = %s, it doesn't respect the following condition : barType < 0", barType));
		this.shortcut = ProtocolTypeManager.getInstance().<Shortcut>newInstance(reader.readShort());
		this.shortcut.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.barType);
		writer.writeShort(this.shortcut.getProtocolTypeId());
		this.shortcut.serialize(writer);
	}
}