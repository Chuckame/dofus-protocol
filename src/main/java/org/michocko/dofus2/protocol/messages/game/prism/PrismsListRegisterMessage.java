package org.michocko.dofus2.protocol.messages.game.prism;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.listen = reader.readSByte();
		if (listen < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on listen = %s, it doesn't respect the following condition : listen < 0", listen));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.listen);
	}
}