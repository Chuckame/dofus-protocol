package org.michocko.dofus2.protocol.types.game.data.items;

import org.michocko.dofus2.protocol.types.game.data.items.Item;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class SpellItem extends Item {
	public static final short TYPE_ID = 49;
	
	private short position;
	private int spellId;
	private byte spellLevel;
	
	public SpellItem() {
	}
	
	public SpellItem(short position, int spellId, byte spellLevel) {
		this.position = position;
		this.spellId = spellId;
		this.spellLevel = spellLevel;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.position = reader.readByte();
		if (position < 63 || position > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on position = %s, it doesn't respect the following condition : position < 63 || position > 255", position));
		this.spellId = reader.readInt();
		this.spellLevel = reader.readSByte();
		if (spellLevel < 1 || spellLevel > 6)
			throw new IllegalArgumentException(String.format("Forbidden value on spellLevel = %s, it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6", spellLevel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.position);
		writer.writeInt(this.spellId);
		writer.writeSByte(this.spellLevel);
	}
}