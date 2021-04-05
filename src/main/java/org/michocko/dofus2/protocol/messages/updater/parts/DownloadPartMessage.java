package org.michocko.dofus2.protocol.messages.updater.parts;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DownloadPartMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 1503;
	
	private String id;
	
	public DownloadPartMessage() {
	}
	
	public DownloadPartMessage(String id) {
		this.id = id;
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
		this.id = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.id);
	}
}