package org.michocko.dofus2.protocol.messages.game.context.roleplay.lockable;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LockableStateUpdateAbstractMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5671;
	
	private boolean locked;
	
	public LockableStateUpdateAbstractMessage() {
	}
	
	public LockableStateUpdateAbstractMessage(boolean locked) {
		this.locked = locked;
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
		this.locked = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.locked);
	}
}