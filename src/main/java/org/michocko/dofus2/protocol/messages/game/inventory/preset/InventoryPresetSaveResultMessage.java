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
public class InventoryPresetSaveResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6170;
	
	private byte presetId;
	private byte code;
	
	public InventoryPresetSaveResultMessage() {
	}
	
	public InventoryPresetSaveResultMessage(byte presetId, byte code) {
		this.presetId = presetId;
		this.code = code;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.code = reader.readSByte();
		if (code < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on code = %s, it doesn't respect the following condition : code < 0", code));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		writer.writeSByte(this.code);
	}
}