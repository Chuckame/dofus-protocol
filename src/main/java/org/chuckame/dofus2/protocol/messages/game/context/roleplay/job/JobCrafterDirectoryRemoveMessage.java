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
public class JobCrafterDirectoryRemoveMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5653;
	
	private byte jobId;
	private int playerId;
	
	public JobCrafterDirectoryRemoveMessage() {
	}
	
	public JobCrafterDirectoryRemoveMessage(byte jobId, int playerId) {
		this.jobId = jobId;
		this.playerId = playerId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.jobId = reader.readSByte();
		if (jobId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobId = %s, it doesn't respect the following condition : jobId < 0", jobId));
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.jobId);
		writer.writeInt(this.playerId);
	}
}