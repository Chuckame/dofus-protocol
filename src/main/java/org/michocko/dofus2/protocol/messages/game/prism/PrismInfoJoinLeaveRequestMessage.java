package org.michocko.dofus2.protocol.messages.game.prism;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismInfoJoinLeaveRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5844;
	
	private boolean join;
	
	public PrismInfoJoinLeaveRequestMessage() {
	}
	
	public PrismInfoJoinLeaveRequestMessage(boolean join) {
		this.join = join;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.join = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.join);
	}
}