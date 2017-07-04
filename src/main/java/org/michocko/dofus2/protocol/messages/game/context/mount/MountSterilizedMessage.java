package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountSterilizedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5977;
	
	private double mountId;
	
	public MountSterilizedMessage() {
	}
	
	public MountSterilizedMessage(double mountId) {
		this.mountId = mountId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mountId = reader.readDouble();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.mountId);
	}
}