package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightInvisibleObstacleMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5820;
	
	private int sourceSpellId;
	
	public GameActionFightInvisibleObstacleMessage() {
	}
	
	public GameActionFightInvisibleObstacleMessage(short actionId, int sourceId, int sourceSpellId) {
		super(actionId, sourceId);
		this.sourceSpellId = sourceSpellId;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.sourceSpellId = reader.readInt();
		if (sourceSpellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on sourceSpellId = %s, it doesn't respect the following condition : sourceSpellId < 0", sourceSpellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.sourceSpellId);
	}
}