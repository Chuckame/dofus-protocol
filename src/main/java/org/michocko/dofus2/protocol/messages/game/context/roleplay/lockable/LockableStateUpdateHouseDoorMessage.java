package org.michocko.dofus2.protocol.messages.game.context.roleplay.lockable;

import org.michocko.dofus2.protocol.messages.game.context.roleplay.lockable.LockableStateUpdateAbstractMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class LockableStateUpdateHouseDoorMessage extends LockableStateUpdateAbstractMessage {
	public static final int MESSAGE_ID = 5668;
	
	private int houseId;
	
	public LockableStateUpdateHouseDoorMessage() {
	}
	
	public LockableStateUpdateHouseDoorMessage(boolean locked, int houseId) {
		super(locked);
		this.houseId = houseId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.houseId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.houseId);
	}
}