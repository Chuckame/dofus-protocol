package org.michocko.dofus2.protocol.types.game.shortcut;

import org.michocko.dofus2.protocol.types.game.shortcut.Shortcut;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class ShortcutSpell extends Shortcut {
	public static final short TYPE_ID = 368;
	
	private short spellId;
	
	public ShortcutSpell() {
	}
	
	public ShortcutSpell(int slot, short spellId) {
		super(slot);
		this.spellId = spellId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.spellId);
	}
}