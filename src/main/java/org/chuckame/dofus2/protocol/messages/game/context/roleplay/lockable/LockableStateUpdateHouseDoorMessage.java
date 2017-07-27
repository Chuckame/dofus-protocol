package org.chuckame.dofus2.protocol.messages.game.context.roleplay.lockable;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.lockable.LockableStateUpdateAbstractMessage;

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
	public int getProtocolId() {
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