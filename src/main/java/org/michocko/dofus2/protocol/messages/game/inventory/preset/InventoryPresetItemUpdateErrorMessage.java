package org.michocko.dofus2.protocol.messages.game.inventory.preset;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	public int getNetworkMessageId() {
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