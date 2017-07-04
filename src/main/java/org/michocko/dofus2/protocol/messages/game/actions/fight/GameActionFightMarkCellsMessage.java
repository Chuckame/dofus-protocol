package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.types.game.actions.fight.GameActionMark;
import org.michocko.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	public int getNetworkMessageId() {
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