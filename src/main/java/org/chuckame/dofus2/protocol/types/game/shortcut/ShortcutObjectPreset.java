package org.chuckame.dofus2.protocol.types.game.shortcut;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.shortcut.ShortcutObject;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ShortcutObjectPreset extends ShortcutObject {
	public static final short TYPE_ID = 370;
	
	private byte presetId;
	
	public ShortcutObjectPreset() {
	}
	
	public ShortcutObjectPreset(int slot, byte presetId) {
		super(slot);
		this.presetId = presetId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.presetId = reader.readSByte();
		if (presetId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on presetId = %s, it doesn't respect the following condition : presetId < 0", presetId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.presetId);
	}
}