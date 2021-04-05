package org.michocko.dofus2.protocol.types.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.fight.GameFightSpellCooldown;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GameFightResumeSlaveInfo implements INetworkType {
	public static final short TYPE_ID = 364;
	
	private int slaveId;
	private Collection<GameFightSpellCooldown> spellCooldowns;
	private byte summonCount;
	private byte bombCount;
	
	public GameFightResumeSlaveInfo() {
	}
	
	public GameFightResumeSlaveInfo(int slaveId, Collection<GameFightSpellCooldown> spellCooldowns, byte summonCount, byte bombCount) {
		this.slaveId = slaveId;
		this.spellCooldowns = spellCooldowns;
		this.summonCount = summonCount;
		this.bombCount = bombCount;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.slaveId = reader.readInt();
		int length = reader.readUShort();
		this.spellCooldowns = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameFightSpellCooldown entry = new GameFightSpellCooldown();
			entry.deserialize(reader);
			this.spellCooldowns.add(entry);
		}
		this.summonCount = reader.readSByte();
		if (summonCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on summonCount = %s, it doesn't respect the following condition : summonCount < 0", summonCount));
		this.bombCount = reader.readSByte();
		if (bombCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on bombCount = %s, it doesn't respect the following condition : bombCount < 0", bombCount));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.slaveId);
		writer.writeUShort(this.spellCooldowns.size());
		for (GameFightSpellCooldown entry : this.spellCooldowns)
		{
			entry.serialize(writer);
		}
		writer.writeSByte(this.summonCount);
		writer.writeSByte(this.bombCount);
	}
}