package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.messages.game.actions.fight.AbstractGameActionFightTargetedAbilityMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightSpellCastMessage extends AbstractGameActionFightTargetedAbilityMessage {
	public static final int MESSAGE_ID = 1010;
	
	private short spellId;
	private byte spellLevel;
	
	public GameActionFightSpellCastMessage() {
	}
	
	public GameActionFightSpellCastMessage(short actionId, int sourceId, int targetId, short destinationCellId, byte critical, boolean silentCast, short spellId, byte spellLevel) {
		super(actionId, sourceId, targetId, destinationCellId, critical, silentCast);
		this.spellId = spellId;
		this.spellLevel = spellLevel;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.spellId = reader.readShort();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
		this.spellLevel = reader.readSByte();
		if (spellLevel < 1 || spellLevel > 6)
			throw new IllegalArgumentException(String.format("Forbidden value on spellLevel = %s, it doesn't respect the following condition : spellLevel < 1 || spellLevel > 6", spellLevel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.spellId);
		writer.writeSByte(this.spellLevel);
	}
}