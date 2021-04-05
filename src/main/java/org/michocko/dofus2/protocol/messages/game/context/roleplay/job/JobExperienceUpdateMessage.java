package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobExperience;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.experiencesUpdate = new JobExperience();
		this.experiencesUpdate.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.experiencesUpdate.serialize(writer);
	}
}