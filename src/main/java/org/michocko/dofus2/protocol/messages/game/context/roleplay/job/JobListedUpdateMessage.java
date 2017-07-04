package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobListedUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6016;
	
	private boolean addedOrDeleted;
	private byte jobId;
	
	public JobListedUpdateMessage() {
	}
	
	public JobListedUpdateMessage(boolean addedOrDeleted, byte jobId) {
		this.addedOrDeleted = addedOrDeleted;
		this.jobId = jobId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.addedOrDeleted = reader.readBoolean();
		this.jobId = reader.readSByte();
		if (jobId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobId = %s, it doesn't respect the following condition : jobId < 0", jobId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.addedOrDeleted);
		writer.writeSByte(this.jobId);
	}
}