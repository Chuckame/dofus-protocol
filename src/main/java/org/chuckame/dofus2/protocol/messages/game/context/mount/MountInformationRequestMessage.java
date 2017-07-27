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
	
	public int getProtocolId() {
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