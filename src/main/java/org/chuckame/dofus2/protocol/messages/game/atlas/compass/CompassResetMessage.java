package org.chuckame.dofus2.protocol.messages.game.atlas.compass;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class CompassResetMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5584;
	
	private byte type;
	
	public CompassResetMessage() {
	}
	
	public CompassResetMessage(byte type) {
		this.type = type;
	}
	
	public int getProtocolId() {
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