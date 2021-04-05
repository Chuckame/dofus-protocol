package org.michocko.dofus2.protocol.messages.game.inventory.preset;

import org.michocko.dofus2.protocol.types.game.inventory.preset.PresetItem;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.presetItem = new PresetItem();
		this.presetItem.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		this.presetItem.serialize(writer);
	}
}