package org.michocko.dofus2.protocol.messages.game.script;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.urlId = reader.readInt();
		if (urlId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on urlId = %s, it doesn't respect the following condition : urlId < 0", urlId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.urlId);
	}
}