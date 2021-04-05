package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import java.util.Collection;
import java.util.LinkedList;

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
public class JobExperienceMultiUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5809;
	
	private Collection<JobExperience> experiencesUpdate;
	
	public JobExperienceMultiUpdateMessage() {
	}
	
	public JobExperienceMultiUpdateMessage(Collection<JobExperience> experiencesUpdate) {
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
		int length = reader.readUShort();
		this.experiencesUpdate = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			JobExperience entry = new JobExperience();
			entry.deserialize(reader);
			this.experiencesUpdate.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.experiencesUpdate.size());
		for (JobExperience entry : this.experiencesUpdate)
		{
			entry.serialize(writer);
		}
	}
}