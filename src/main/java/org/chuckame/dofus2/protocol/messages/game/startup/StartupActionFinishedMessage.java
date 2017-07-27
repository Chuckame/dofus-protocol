package org.chuckame.dofus2.protocol.messages.game.startup;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StartupActionFinishedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1304;
	
	private int actionId;
	
	public StartupActionFinishedMessage() {
	}
	
	public StartupActionFinishedMessage(int actionId) {
		this.actionId = actionId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.actionId = reader.readInt();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.actionId);
	}
}