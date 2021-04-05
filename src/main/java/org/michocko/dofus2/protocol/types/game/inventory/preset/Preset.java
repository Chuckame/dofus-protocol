package org.michocko.dofus2.protocol.types.game.inventory.preset;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.inventory.preset.PresetItem;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class Preset implements INetworkType {
	public static final short TYPE_ID = 355;
	
	private byte presetId;
	private byte symbolId;
	private boolean mount;
	private Collection<PresetItem> objects;
	
	public Preset() {
	}
	
	public Preset(byte presetId, byte symbolId, boolean mount, Collection<PresetItem> objects) {
		this.presetId = presetId;
		this.symbolId = symbolId;
		this.mount = mount;
		this.objects = objects;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
		this.symbolId = reader.readSByte();
		if (symbolId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on symbolId = %s, it doesn't respect the following condition : symbolId < 0", symbolId));
		this.mount = reader.readBoolean();
		int length = reader.readUShort();
		this.objects = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			PresetItem entry = new PresetItem();
			entry.deserialize(reader);
			this.objects.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.presetId);
		writer.writeSByte(this.symbolId);
		writer.writeBoolean(this.mount);
		writer.writeUShort(this.objects.size());
		for (PresetItem entry : this.objects)
		{
			entry.serialize(writer);
		}
	}
}