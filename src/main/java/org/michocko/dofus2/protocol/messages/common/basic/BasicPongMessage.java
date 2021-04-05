package org.michocko.dofus2.protocol.messages.common.basic;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicPongMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 183;
	
	private boolean quiet;
	
	public BasicPongMessage() {
	}
	
	public BasicPongMessage(boolean quiet) {
		this.quiet = quiet;
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
		this.quiet = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.quiet);
	}
}