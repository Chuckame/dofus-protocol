package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightLoot;
import org.michocko.dofus2.protocol.types.game.context.fight.FightResultFighterListEntry;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightResultMutantListEntry extends FightResultFighterListEntry {
	public static final short TYPE_ID = 216;
	
	private int level;
	
	public FightResultMutantListEntry() {
	}
	
	public FightResultMutantListEntry(short outcome, long wave, FightLoot rewards, int id, boolean alive, int level) {
		super(outcome, wave, rewards, id, alive);
		this.level = level;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.level = reader.readUShort();
		if (level < 0 || level > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0 || level > 65535", level));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.level);
	}
}