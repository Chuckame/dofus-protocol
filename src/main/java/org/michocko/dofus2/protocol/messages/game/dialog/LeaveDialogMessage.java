package org.michocko.dofus2.protocol.messages.game.dialog;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LeaveDialogMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5502;
	
	private byte dialogType;
	
	public LeaveDialogMessage() {
	}
	
	public LeaveDialogMessage(byte dialogType) {
		this.dialogType = dialogType;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.dialogType = reader.readSByte();
		if (dialogType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dialogType = %s, it doesn't respect the following condition : dialogType < 0", dialogType));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.dialogType);
	}
}