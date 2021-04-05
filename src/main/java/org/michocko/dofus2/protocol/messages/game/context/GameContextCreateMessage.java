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
public class GameContextCreateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 200;
	
	private byte context;
	
	public GameContextCreateMessage() {
	}
	
	public GameContextCreateMessage(byte context) {
		this.context = context;
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
		this.context = reader.readSByte();
		if (context < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on context = %s, it doesn't respect the following condition : context < 0", context));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.context);
	}
}