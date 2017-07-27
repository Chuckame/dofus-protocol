package org.chuckame.dofus2.protocol.messages.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.fight.GameFightResumeMessage;
import org.chuckame.dofus2.protocol.types.game.action.fight.FightDispellableEffectExtendedInformations;
import org.chuckame.dofus2.protocol.types.game.actions.fight.GameActionMark;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightResumeSlaveInfo;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightSpellCooldown;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameFightResumeWithSlavesMessage extends GameFightResumeMessage {
	public static final int MESSAGE_ID = 6215;
	
	private Collection<GameFightResumeSlaveInfo> slavesInfo;
	
	public GameFightResumeWithSlavesMessage() {
	}
	
	public GameFightResumeWithSlavesMessage(Collection<FightDispellableEffectExtendedInformations> effects, Collection<GameActionMark> marks, short gameTurn, Collection<GameFightSpellCooldown> spellCooldowns, byte summonCount, byte bombCount, Collection<GameFightResumeSlaveInfo> slavesInfo) {
		super(effects, marks, gameTurn, spellCooldowns, summonCount, bombCount);
		this.slavesInfo = slavesInfo;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.slavesInfo = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameFightResumeSlaveInfo entry = new GameFightResumeSlaveInfo();
			entry.deserialize(reader);
			this.slavesInfo.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.slavesInfo.size());
		for (GameFightResumeSlaveInfo entry : this.slavesInfo)
		{
			entry.serialize(writer);
		}
	}
}