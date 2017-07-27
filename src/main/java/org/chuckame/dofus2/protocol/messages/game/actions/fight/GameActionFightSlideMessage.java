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
public class GameActionFightSlideMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5525;
	
	private int targetId;
	private short startCellId;
	private short endCellId;
	
	public GameActionFightSlideMessage() {
	}
	
	public GameActionFightSlideMessage(short actionId, int sourceId, int targetId, short startCellId, short endCellId) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.startCellId = startCellId;
		this.endCellId = endCellId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.startCellId = reader.readShort();
		if (startCellId < -1 || startCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on startCellId = %s, it doesn't respect the following condition : startCellId < -1 || startCellId > 559", startCellId));
		this.endCellId = reader.readShort();
		if (endCellId < -1 || endCellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on endCellId = %s, it doesn't respect the following condition : endCellId < -1 || endCellId > 559", endCellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.startCellId);
		writer.writeShort(this.endCellId);
	}
}