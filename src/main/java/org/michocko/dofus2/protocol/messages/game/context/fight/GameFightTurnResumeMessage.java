package org.michocko.dofus2.protocol.messages.game.context.fight;

import org.michocko.dofus2.protocol.messages.game.context.fight.GameFightTurnStartMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameFightTurnResumeMessage extends GameFightTurnStartMessage {
	public static final int MESSAGE_ID = 6307;
	
	
	public GameFightTurnResumeMessage() {
	}
	
	public GameFightTurnResumeMessage(int id, int waitTime) {
		super(id, waitTime);
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}