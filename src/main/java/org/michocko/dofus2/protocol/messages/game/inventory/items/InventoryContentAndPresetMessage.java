package org.michocko.dofus2.protocol.messages.game.inventory.items;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.inventory.preset.Preset;
import org.michocko.dofus2.protocol.types.game.data.items.ObjectItem;
import org.michocko.dofus2.protocol.messages.game.inventory.items.InventoryContentMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class InventoryContentAndPresetMessage extends InventoryContentMessage {
	public static final int MESSAGE_ID = 6162;
	
	private Collection<Preset> presets;
	
	public InventoryContentAndPresetMessage() {
	}
	
	public InventoryContentAndPresetMessage(Collection<ObjectItem> objects, int kamas, Collection<Preset> presets) {
		super(objects, kamas);
		this.presets = presets;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.presets = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			Preset entry = new Preset();
			entry.deserialize(reader);
			this.presets.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.presets.size());
		for (Preset entry : this.presets)
		{
			entry.serialize(writer);
		}
	}
}