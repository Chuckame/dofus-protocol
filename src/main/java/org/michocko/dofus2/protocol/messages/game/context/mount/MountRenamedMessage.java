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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.mountId = reader.readDouble();
		this.name = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeDouble(this.mountId);
		writer.writeUTF(this.name);
	}
}