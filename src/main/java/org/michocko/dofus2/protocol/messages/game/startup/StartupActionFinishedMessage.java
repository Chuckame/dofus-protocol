package org.michocko.dofus2.protocol.messages.game.startup;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.actionId = reader.readInt();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.actionId);
	}
}