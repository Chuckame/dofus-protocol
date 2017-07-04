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
public class MountEquipedErrorMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5963;
	
	private byte errorType;
	
	public MountEquipedErrorMessage() {
	}
	
	public MountEquipedErrorMessage(byte errorType) {
		this.errorType = errorType;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.errorType = reader.readSByte();
		if (errorType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on errorType = %s, it doesn't respect the following condition : errorType < 0", errorType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.errorType);
	}
}