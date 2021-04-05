package org.michocko.dofus2.protocol.messages.game.pvp;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class UpdateSelfAgressableStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6456;
	
	private byte status;
	private int probationTime;
	
	public UpdateSelfAgressableStatusMessage() {
	}
	
	public UpdateSelfAgressableStatusMessage(byte status, int probationTime) {
		this.status = status;
		this.probationTime = probationTime;
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
		this.status = reader.readSByte();
		if (status < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on status = %s, it doesn't respect the following condition : status < 0", status));
		this.probationTime = reader.readInt();
		if (probationTime < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on probationTime = %s, it doesn't respect the following condition : probationTime < 0", probationTime));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.status);
		writer.writeInt(this.probationTime);
	}
}