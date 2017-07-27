package org.chuckame.dofus2.protocol.messages.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.fight.GameFightSpectateMessage;
import org.chuckame.dofus2.protocol.types.game.action.fight.FightDispellableEffectExtendedInformations;
import org.chuckame.dofus2.protocol.types.game.actions.fight.GameActionMark;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightSpellCooldown;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameFightResumeMessage extends GameFightSpectateMessage {
	public static final int MESSAGE_ID = 6067;
	
	private Collection<GameFightSpellCooldown> spellCooldowns;
	private byte summonCount;
	private byte bombCount;
	
	public GameFightResumeMessage() {
	}
	
	public GameFightResumeMessage(Collection<FightDispellableEffectExtendedInformations> effects, Collection<GameActionMark> marks, short gameTurn, Collection<GameFightSpellCooldown> spellCooldowns, byte summonCount, byte bombCount) {
		super(effects, marks, gameTurn);
		this.spellCooldowns = spellCooldowns;
		this.summonCount = summonCount;
		this.bombCount = bombCount;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
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
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.spellCooldowns.size());
		for (GameFightSpellCooldown entry : this.spellCooldowns)
		{
			entry.serialize(writer);
		}
		writer.writeSByte(this.summonCount);
		writer.writeSByte(this.bombCount);
	}
}