package org.chuckame.dofus2.protocol.types.game.shortcut;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.shortcut.Shortcut;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ShortcutSmiley extends Shortcut {
	public static final short TYPE_ID = 388;
	
	private byte smileyId;
	
	public ShortcutSmiley() {
	}
	
	public ShortcutSmiley(int slot, byte smileyId) {
		super(slot);
		this.smileyId = smileyId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.smileyId = reader.readSByte();
		if (smileyId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on smileyId = %s, it doesn't respect the following condition : smileyId < 0", smileyId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.smileyId);
	}
}