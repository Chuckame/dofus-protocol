package org.michocko.dofus2.protocol.messages.game.actions;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AbstractGameActionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1000;
	
	private short actionId;
	private int sourceId;
	
	public AbstractGameActionMessage() {
	}
	
	public AbstractGameActionMessage(short actionId, int sourceId) {
		this.actionId = actionId;
		this.sourceId = sourceId;
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
		this.actionId = reader.readShort();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
		this.sourceId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.actionId);
		writer.writeInt(this.sourceId);
	}
}