package org.chuckame.dofus2.protocol.messages.debug;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class DebugInClientMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6028;
	
	private byte level;
	private String message;
	
	public DebugInClientMessage() {
	}
	
	public DebugInClientMessage(byte level, String message) {
		this.level = level;
		this.message = message;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.level = reader.readSByte();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
		this.message = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.level);
		writer.writeUTF(this.message);
	}
}