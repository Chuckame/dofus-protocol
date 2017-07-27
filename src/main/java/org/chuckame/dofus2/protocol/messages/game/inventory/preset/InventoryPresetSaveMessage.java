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
public class InventoryPresetSaveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6165;
	
	private byte presetId;
	private byte symbolId;
	private boolean saveEquipment;
	
	public InventoryPresetSaveMessage() {
	}
	
	public InventoryPresetSaveMessage(byte presetId, byte symbolId, boolean saveEquipment) {
		this.presetId = presetId;
		this.symbolId = symbolId;
		this.saveEquipment = saveEquipment;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.symbolId = reader.readSByte();
		if (symbolId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on symbolId = %s, it doesn't respect the following condition : symbolId < 0", symbolId));
		this.saveEquipment = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		writer.writeSByte(this.symbolId);
		writer.writeBoolean(this.saveEquipment);
	}
}