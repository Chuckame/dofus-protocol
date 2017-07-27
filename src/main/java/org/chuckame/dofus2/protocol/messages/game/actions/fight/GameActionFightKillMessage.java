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
public class GameActionFightKillMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 5571;
	
	private int targetId;
	
	public GameActionFightKillMessage() {
	}
	
	public GameActionFightKillMessage(short actionId, int sourceId, int targetId) {
		super(actionId, sourceId);
		this.targetId = targetId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.targetId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.targetId);
	}
}