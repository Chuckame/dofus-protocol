package org.chuckame.dofus2.protocol.messages.game.script;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class URLOpenMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6266;
	
	private int urlId;
	
	public URLOpenMessage() {
	}
	
	public URLOpenMessage(int urlId) {
		this.urlId = urlId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.urlId = reader.readInt();
		if (urlId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on urlId = %s, it doesn't respect the following condition : urlId < 0", urlId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.urlId);
	}
}