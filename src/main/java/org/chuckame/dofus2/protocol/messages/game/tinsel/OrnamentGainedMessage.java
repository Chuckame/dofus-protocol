package org.chuckame.dofus2.protocol.messages.game.tinsel;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class OrnamentGainedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6368;
	
	private short ornamentId;
	
	public OrnamentGainedMessage() {
	}
	
	public OrnamentGainedMessage(short ornamentId) {
		this.ornamentId = ornamentId;
	}
	
	public int getProtocolId() {
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