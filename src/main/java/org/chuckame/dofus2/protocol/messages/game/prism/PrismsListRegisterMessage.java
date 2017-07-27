package org.chuckame.dofus2.protocol.messages.game.prism;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PrismsListRegisterMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6441;
	
	private byte listen;
	
	public PrismsListRegisterMessage() {
	}
	
	public PrismsListRegisterMessage(byte listen) {
		this.listen = listen;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.listen = reader.readSByte();
		if (listen < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on listen = %s, it doesn't respect the following condition : listen < 0", listen));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.listen);
	}
}