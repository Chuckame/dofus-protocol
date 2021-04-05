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
public class ShortcutBarRemoveErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6222;
	
	private byte error;
	
	public ShortcutBarRemoveErrorMessage() {
	}
	
	public ShortcutBarRemoveErrorMessage(byte error) {
		this.error = error;
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
		this.error = reader.readSByte();
		if (error < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on error = %s, it doesn't respect the following condition : error < 0", error));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.error);
	}
}