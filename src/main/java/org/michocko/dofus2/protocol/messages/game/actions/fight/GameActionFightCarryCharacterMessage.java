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
public class GameActionFightCarryCharacterMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5830;
	
	private int targetId;
	private short cellId;
	
	public GameActionFightCarryCharacterMessage() {
	}
	
	public GameActionFightCarryCharacterMessage(short actionId, int sourceId, int targetId, short cellId) {
		super(actionId, sourceId);
		this.targetId = targetId;
		this.cellId = cellId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
		this.cellId = reader.readShort();
		if (cellId < -1 || cellId > 559)
			throw new IllegalArgumentException(String.format("Forbidden value on cellId = %s, it doesn't respect the following condition : cellId < -1 || cellId > 559", cellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
		writer.writeShort(this.cellId);
	}
}