package org.chuckame.dofus2.protocol.messages.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameMapChangeOrientationRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 945;
	
	private byte direction;
	
	public GameMapChangeOrientationRequestMessage() {
	}
	
	public GameMapChangeOrientationRequestMessage(byte direction) {
		this.direction = direction;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.direction = reader.readSByte();
		if (direction < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on direction = %s, it doesn't respect the following condition : direction < 0", direction));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.direction);
	}
}