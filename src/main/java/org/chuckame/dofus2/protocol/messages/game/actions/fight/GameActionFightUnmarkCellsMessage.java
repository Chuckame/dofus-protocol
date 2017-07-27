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
public class GameActionFightUnmarkCellsMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5570;
	
	private short markId;
	
	public GameActionFightUnmarkCellsMessage() {
	}
	
	public GameActionFightUnmarkCellsMessage(short actionId, int sourceId, short markId) {
		super(actionId, sourceId);
		this.markId = markId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.markId = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.markId);
	}
}