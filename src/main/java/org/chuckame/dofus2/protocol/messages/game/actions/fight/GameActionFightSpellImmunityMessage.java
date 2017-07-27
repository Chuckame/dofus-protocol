package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightSpellImmunityMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 6221;
	
	private int targetId;
	private int spellId;
	
	public GameActionFightSpellImmunityMessage() {
	}
	
	public GameActionFightSpellImmunityMessage(short actionId, int sourceId, int targetId, int spellId) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.spellId = spellId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.spellId = reader.readInt();
		if (spellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on spellId = %s, it doesn't respect the following condition : spellId < 0", spellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeInt(this.spellId);
	}
}