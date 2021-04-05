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
public class BasicWhoIsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 181;
	
	private boolean verbose;
	private String search;
	
	public BasicWhoIsRequestMessage() {
	}
	
	public BasicWhoIsRequestMessage(boolean verbose, String search) {
		this.verbose = verbose;
		this.search = search;
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
		this.search = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.verbose);
		writer.writeUTF(this.search);
	}
}