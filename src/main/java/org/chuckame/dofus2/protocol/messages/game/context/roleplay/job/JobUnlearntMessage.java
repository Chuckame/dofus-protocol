package org.chuckame.dofus2.protocol.messages.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobUnlearntMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5657;
	
	private byte jobId;
	
	public JobUnlearntMessage() {
	}
	
	public JobUnlearntMessage(byte jobId) {
		this.jobId = jobId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.jobId = reader.readSByte();
		if (jobId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobId = %s, it doesn't respect the following condition : jobId < 0", jobId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.jobId);
	}
}