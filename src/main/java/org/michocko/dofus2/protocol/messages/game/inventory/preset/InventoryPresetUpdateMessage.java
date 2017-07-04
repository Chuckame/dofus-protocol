package org.michocko.dofus2.protocol.messages.game.inventory.preset;

import org.michocko.dofus2.protocol.types.game.inventory.preset.Preset;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class InventoryPresetUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6171;
	
	private Preset preset;
	
	public InventoryPresetUpdateMessage() {
	}
	
	public InventoryPresetUpdateMessage(Preset preset) {
		this.preset = preset;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.preset = new Preset();
		this.preset.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.preset.serialize(writer);
	}
}