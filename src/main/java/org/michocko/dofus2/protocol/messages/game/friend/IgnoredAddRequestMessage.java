package org.michocko.dofus2.protocol.messages.game.friend;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class IgnoredAddRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5673;
	
	private String name;
	private boolean session;
	
	public IgnoredAddRequestMessage() {
	}
	
	public IgnoredAddRequestMessage(String name, boolean session) {
		this.name = name;
		this.session = session;
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
		this.name = reader.readUTF();
		this.session = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.name);
		writer.writeBoolean(this.session);
	}
}