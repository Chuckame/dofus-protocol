package org.michocko.dofus2.protocol.messages.game.context;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	public int getNetworkMessageId() {
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