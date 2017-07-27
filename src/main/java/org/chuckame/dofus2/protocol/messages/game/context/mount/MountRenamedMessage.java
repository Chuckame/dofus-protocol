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
public class MountRenamedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5983;
	
	private double mountId;
	private String name;
	
	public MountRenamedMessage() {
	}
	
	public MountRenamedMessage(double mountId, String name) {
		this.mountId = mountId;
		this.name = name;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.mountId = reader.readDouble();
		this.name = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.mountId);
		writer.writeUTF(this.name);
	}
}