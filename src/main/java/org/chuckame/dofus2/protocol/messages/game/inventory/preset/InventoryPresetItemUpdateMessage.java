package org.chuckame.dofus2.protocol.messages.game.inventory.preset;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.inventory.preset.PresetItem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InventoryPresetItemUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6168;
	
	private byte presetId;
	private PresetItem presetItem;
	
	public InventoryPresetItemUpdateMessage() {
	}
	
	public InventoryPresetItemUpdateMessage(byte presetId, PresetItem presetItem) {
		this.presetId = presetId;
		this.presetItem = presetItem;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.presetItem = new PresetItem();
		this.presetItem.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		this.presetItem.serialize(writer);
	}
}