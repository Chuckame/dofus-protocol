package org.michocko.dofus2.protocol.messages.game.tinsel;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class OrnamentSelectRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6374;
	
	private short ornamentId;
	
	public OrnamentSelectRequestMessage() {
	}
	
	public OrnamentSelectRequestMessage(short ornamentId) {
		this.ornamentId = ornamentId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.ornamentId = reader.readShort();
		if (ornamentId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on ornamentId = %s, it doesn't respect the following condition : ornamentId < 0", ornamentId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.ornamentId);
	}
}