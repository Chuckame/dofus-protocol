package org.chuckame.dofus2.protocol.messages.game.inventory.preset;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InventoryPresetItemUpdateErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6211;
	
	private byte code;
	
	public InventoryPresetItemUpdateErrorMessage() {
	}
	
	public InventoryPresetItemUpdateErrorMessage(byte code) {
		this.code = code;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.code = reader.readSByte();
		if (code < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on code = %s, it doesn't respect the following condition : code < 0", code));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.code);
	}
}