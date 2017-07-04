package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightLoot;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class FightResultListEntry implements INetworkType {
	public static final short TYPE_ID = 16;
	
	private short outcome;
	private long wave;
	private FightLoot rewards;
	
	public FightResultListEntry() {
	}
	
	public FightResultListEntry(short outcome, long wave, FightLoot rewards) {
		this.outcome = outcome;
		this.wave = wave;
		this.rewards = rewards;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.outcome = reader.readShort();
		if (outcome < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on outcome = %s, it doesn't respect the following condition : outcome < 0", outcome));
		this.wave = reader.readUInt();
		if (wave < 0 || wave > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on wave = %s, it doesn't respect the following condition : wave < 0 || wave > 4.294967295E9", wave));
		this.rewards = new FightLoot();
		this.rewards.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.outcome);
		writer.writeUInt(this.wave);
		this.rewards.serialize(writer);
	}
}