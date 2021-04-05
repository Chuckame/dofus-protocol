package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceCreationResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6391;
	
	private byte result;
	
	public AllianceCreationResultMessage() {
	}
	
	public AllianceCreationResultMessage(byte result) {
		this.result = result;
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
		this.result = reader.readSByte();
		if (result < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on result = %s, it doesn't respect the following condition : result < 0", result));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.result);
	}
}