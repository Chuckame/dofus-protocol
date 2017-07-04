package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightLoot;
import org.michocko.dofus2.protocol.types.game.context.fight.FightResultListEntry;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightResultFighterListEntry extends FightResultListEntry {
	public static final short TYPE_ID = 189;
	
	private int id;
	private boolean alive;
	
	public FightResultFighterListEntry() {
	}
	
	public FightResultFighterListEntry(short outcome, long wave, FightLoot rewards, int id, boolean alive) {
		super(outcome, wave, rewards);
		this.id = id;
		this.alive = alive;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.id = reader.readInt();
		this.alive = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.id);
		writer.writeBoolean(this.alive);
	}
}