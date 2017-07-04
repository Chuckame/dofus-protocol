package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
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
public class FightResultTaxCollectorListEntry extends FightResultFighterListEntry {
	public static final short TYPE_ID = 84;
	
	private short level;
	private BasicGuildInformations guildInfo;
	private int experienceForGuild;
	
	public FightResultTaxCollectorListEntry() {
	}
	
	public FightResultTaxCollectorListEntry(short outcome, long wave, FightLoot rewards, int id, boolean alive, short level, BasicGuildInformations guildInfo, int experienceForGuild) {
		super(outcome, wave, rewards, id, alive);
		this.level = level;
		this.guildInfo = guildInfo;
		this.experienceForGuild = experienceForGuild;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.level = reader.readByte();
		if (level < 1 || level > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 1 || level > 200", level));
		this.guildInfo = new BasicGuildInformations();
		this.guildInfo.deserialize(reader);
		this.experienceForGuild = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.level);
		this.guildInfo.serialize(writer);
		writer.writeInt(this.experienceForGuild);
	}
}