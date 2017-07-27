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
public class MountRenameRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5987;
	
	private String name;
	private double mountId;
	
	public MountRenameRequestMessage() {
	}
	
	public MountRenameRequestMessage(String name, double mountId) {
		this.name = name;
		this.mountId = mountId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.name = reader.readUTF();
		this.mountId = reader.readDouble();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.name);
		writer.writeDouble(this.mountId);
	}
}