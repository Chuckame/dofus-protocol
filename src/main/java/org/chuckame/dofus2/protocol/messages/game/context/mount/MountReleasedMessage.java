package org.chuckame.dofus2.protocol.messages.game.context.mount;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountReleasedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6308;
	
	private double mountId;
	
	public MountReleasedMessage() {
	}
	
	public MountReleasedMessage(double mountId) {
		this.mountId = mountId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mountId = reader.readDouble();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.mountId);
	}
}