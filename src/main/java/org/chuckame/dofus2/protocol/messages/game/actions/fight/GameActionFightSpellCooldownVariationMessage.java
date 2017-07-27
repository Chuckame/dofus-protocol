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
public class GameActionFightSpellCooldownVariationMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 6219;
	
	private int targetId;
	private int spellId;
	private short value;
	
	public GameActionFightSpellCooldownVariationMessage() {
	}
	
	public GameActionFightSpellCooldownVariationMessage(short actionId, int sourceId, int targetId, int spellId, short value) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.spellId = spellId;
		this.value = value;
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
		this.value = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeInt(this.spellId);
		writer.writeShort(this.value);
	}
}