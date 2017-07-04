package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses;

import org.michocko.dofus2.protocol.messages.game.context.roleplay.lockable.LockableChangeCodeMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class HouseLockFromInsideRequestMessage extends LockableChangeCodeMessage {
	public static final int MESSAGE_ID = 5885;
	
	
	public HouseLockFromInsideRequestMessage() {
	}
	
	public HouseLockFromInsideRequestMessage(String code) {
		super(code);
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