package org.michocko.dofus2.protocol.types.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.fight.FightResultAdditionalData;
import org.michocko.dofus2.protocol.types.game.context.fight.FightLoot;
import org.michocko.dofus2.protocol.types.game.context.fight.FightResultFighterListEntry;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightResultPlayerListEntry extends FightResultFighterListEntry {
	public static final short TYPE_ID = 24;
	
	private short level;
	private Collection<FightResultAdditionalData> additional;
	
	public FightResultPlayerListEntry() {
	}
	
	public FightResultPlayerListEntry(short outcome, long wave, FightLoot rewards, int id, boolean alive, short level, Collection<FightResultAdditionalData> additional) {
		super(outcome, wave, rewards, id, alive);
		this.level = level;
		this.additional = additional;
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
		int length = reader.readUShort();
		this.additional = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightResultAdditionalData entry = ProtocolTypeManager.getInstance().<FightResultAdditionalData>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.additional.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.level);
		writer.writeUShort(this.additional.size());
		for (FightResultAdditionalData entry : this.additional)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}