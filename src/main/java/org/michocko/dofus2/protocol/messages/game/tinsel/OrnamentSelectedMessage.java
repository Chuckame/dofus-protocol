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
public class OrnamentSelectedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6369;
	
	private short ornamentId;
	
	public OrnamentSelectedMessage() {
	}
	
	public OrnamentSelectedMessage(short ornamentId) {
		this.ornamentId = ornamentId;
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
		this.ornamentId = reader.readShort();
		if (ornamentId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on ornamentId = %s, it doesn't respect the following condition : ornamentId < 0", ornamentId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.ornamentId);
	}
}