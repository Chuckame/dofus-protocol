package org.michocko.dofus2.protocol.messages.game.context.fight;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameFightTurnStartMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 714;
	
	private int id;
	private int waitTime;
	
	public GameFightTurnStartMessage() {
	}
	
	public GameFightTurnStartMessage(int id, int waitTime) {
		this.id = id;
		this.waitTime = waitTime;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		this.waitTime = reader.readInt();
		if (waitTime < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on waitTime = %s, it doesn't respect the following condition : waitTime < 0", waitTime));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		writer.writeInt(this.waitTime);
	}
}