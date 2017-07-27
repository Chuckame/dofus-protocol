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
public class GameActionFightTriggerGlyphTrapMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5741;
	
	private short markId;
	private int triggeringCharacterId;
	private short triggeredSpellId;
	
	public GameActionFightTriggerGlyphTrapMessage() {
	}
	
	public GameActionFightTriggerGlyphTrapMessage(short actionId, int sourceId, short markId, int triggeringCharacterId, short triggeredSpellId) {
		super(actionId, sourceId);
		this.markId = markId;
		this.triggeringCharacterId = triggeringCharacterId;
		this.triggeredSpellId = triggeredSpellId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.markId = reader.readShort();
		this.triggeringCharacterId = reader.readInt();
		this.triggeredSpellId = reader.readShort();
		if (triggeredSpellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on triggeredSpellId = %s, it doesn't respect the following condition : triggeredSpellId < 0", triggeredSpellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.markId);
		writer.writeInt(this.triggeringCharacterId);
		writer.writeShort(this.triggeredSpellId);
	}
}