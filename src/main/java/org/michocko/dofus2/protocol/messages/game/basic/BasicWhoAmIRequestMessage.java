package org.michocko.dofus2.protocol.messages.game.basic;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class BasicWhoAmIRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5664;
	
	private boolean verbose;
	
	public BasicWhoAmIRequestMessage() {
	}
	
	public BasicWhoAmIRequestMessage(boolean verbose) {
		this.verbose = verbose;
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
		this.verbose = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.verbose);
	}
}