package org.chuckame.dofus2.protocol.messages.game.context.roleplay.lockable;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class LockableShowCodeDialogMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5740;
	
	private boolean changeOrUse;
	private byte codeSize;
	
	public LockableShowCodeDialogMessage() {
	}
	
	public LockableShowCodeDialogMessage(boolean changeOrUse, byte codeSize) {
		this.changeOrUse = changeOrUse;
		this.codeSize = codeSize;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.changeOrUse = reader.readBoolean();
		this.codeSize = reader.readSByte();
		if (codeSize < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on codeSize = %s, it doesn't respect the following condition : codeSize < 0", codeSize));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.changeOrUse);
		writer.writeSByte(this.codeSize);
	}
}