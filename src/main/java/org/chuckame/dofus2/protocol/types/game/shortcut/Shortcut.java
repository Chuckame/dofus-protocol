package org.chuckame.dofus2.protocol.types.game.shortcut;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class Shortcut implements INetworkType {
	public static final short TYPE_ID = 369;
	
	private int slot;
	
	public Shortcut() {
	}
	
	public Shortcut(int slot) {
		this.slot = slot;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.slot = reader.readInt();
		if (slot < 0 || slot > 99)
			throw new IllegalArgumentException(String.format("Forbidden value on slot = %s, it doesn't respect the following condition : slot < 0 || slot > 99", slot));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.slot);
	}
}