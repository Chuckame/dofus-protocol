package org.michocko.dofus2.protocol.messages.game.context.mount;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MountXpRatioMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5970;
	
	private byte ratio;
	
	public MountXpRatioMessage() {
	}
	
	public MountXpRatioMessage(byte ratio) {
		this.ratio = ratio;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.ratio = reader.readSByte();
		if (ratio < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on ratio = %s, it doesn't respect the following condition : ratio < 0", ratio));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.ratio);
	}
}