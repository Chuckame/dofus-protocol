package org.chuckame.dofus2.protocol.messages.updater.parts;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.id);
	}
}