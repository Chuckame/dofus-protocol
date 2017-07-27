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
public class InventoryPresetDeleteResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6173;
	
	private byte presetId;
	private byte code;
	
	public InventoryPresetDeleteResultMessage() {
	}
	
	public InventoryPresetDeleteResultMessage(byte presetId, byte code) {
		this.presetId = presetId;
		this.code = code;
	}
	
	public int getProtocolId() {
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