package org.chuckame.dofus2.protocol.messages.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.job.JobExperience;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobExperienceUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5654;
	
	private JobExperience experiencesUpdate;
	
	public JobExperienceUpdateMessage() {
	}
	
	public JobExperienceUpdateMessage(JobExperience experiencesUpdate) {
		this.experiencesUpdate = experiencesUpdate;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.experiencesUpdate = new JobExperience();
		this.experiencesUpdate.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.experiencesUpdate.serialize(writer);
	}
}