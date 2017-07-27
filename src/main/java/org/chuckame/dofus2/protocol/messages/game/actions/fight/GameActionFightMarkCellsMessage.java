package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;
import org.chuckame.dofus2.protocol.types.game.actions.fight.GameActionMark;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightMarkCellsMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5540;
	
	private GameActionMark mark;
	
	public GameActionFightMarkCellsMessage() {
	}
	
	public GameActionFightMarkCellsMessage(short actionId, int sourceId, GameActionMark mark) {
		super(actionId, sourceId);
		this.mark = mark;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.mark = new GameActionMark();
		this.mark.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.mark.serialize(writer);
	}
}