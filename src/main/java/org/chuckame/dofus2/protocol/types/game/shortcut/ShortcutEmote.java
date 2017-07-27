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
public class ShortcutEmote extends Shortcut {
	public static final short TYPE_ID = 389;
	
	private short emoteId;
	
	public ShortcutEmote() {
	}
	
	public ShortcutEmote(int slot, short emoteId) {
		super(slot);
		this.emoteId = emoteId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.emoteId = reader.readByte();
		if (emoteId < 0 || emoteId > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on emoteId = %s, it doesn't respect the following condition : emoteId < 0 || emoteId > 255", emoteId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.emoteId);
	}
}