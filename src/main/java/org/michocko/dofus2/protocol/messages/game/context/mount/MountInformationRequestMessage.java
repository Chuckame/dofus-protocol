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
public class MountInformationRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5972;
	
	private double id;
	private double time;
	
	public MountInformationRequestMessage() {
	}
	
	public MountInformationRequestMessage(double id, double time) {
		this.id = id;
		this.time = time;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readDouble();
		this.time = reader.readDouble();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.id);
		writer.writeDouble(this.time);
	}
}