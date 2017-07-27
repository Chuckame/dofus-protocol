package org.chuckame.dofus2.protocol.messages.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.job.JobDescription;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobLevelUpMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5656;
	
	private byte newLevel;
	private JobDescription jobsDescription;
	
	public JobLevelUpMessage() {
	}
	
	public JobLevelUpMessage(byte newLevel, JobDescription jobsDescription) {
		this.newLevel = newLevel;
		this.jobsDescription = jobsDescription;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.newLevel = reader.readSByte();
		if (newLevel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on newLevel = %s, it doesn't respect the following condition : newLevel < 0", newLevel));
		this.jobsDescription = new JobDescription();
		this.jobsDescription.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.newLevel);
		this.jobsDescription.serialize(writer);
	}
}