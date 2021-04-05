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
public class PauseDialogMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6012;
	
	private byte dialogType;
	
	public PauseDialogMessage() {
	}
	
	public PauseDialogMessage(byte dialogType) {
		this.dialogType = dialogType;
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
		this.dialogType = reader.readSByte();
		if (dialogType < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on dialogType = %s, it doesn't respect the following condition : dialogType < 0", dialogType));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.dialogType);
	}
}