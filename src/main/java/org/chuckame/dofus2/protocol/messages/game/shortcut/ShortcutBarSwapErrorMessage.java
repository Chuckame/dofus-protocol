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
public class ShortcutBarSwapErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6226;
	
	private byte error;
	
	public ShortcutBarSwapErrorMessage() {
	}
	
	public ShortcutBarSwapErrorMessage(byte error) {
		this.error = error;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.error = reader.readSByte();
		if (error < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on error = %s, it doesn't respect the following condition : error < 0", error));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.error);
	}
}