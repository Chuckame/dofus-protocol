package org.michocko.dofus2.protocol.messages.game.ui;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ClientUIOpenedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6459;
	
	private byte type;
	
	public ClientUIOpenedMessage() {
	}
	
	public ClientUIOpenedMessage(byte type) {
		this.type = type;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.type = reader.readSByte();
		if (type < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on type = %s, it doesn't respect the following condition : type < 0", type));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.type);
	}
}