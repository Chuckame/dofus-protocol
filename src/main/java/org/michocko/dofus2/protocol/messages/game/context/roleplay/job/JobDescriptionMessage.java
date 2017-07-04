package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobDescription;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobDescriptionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5655;
	
	private Collection<JobDescription> jobsDescription;
	
	public JobDescriptionMessage() {
	}
	
	public JobDescriptionMessage(Collection<JobDescription> jobsDescription) {
		this.jobsDescription = jobsDescription;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.jobsDescription = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			JobDescription entry = new JobDescription();
			entry.deserialize(reader);
			this.jobsDescription.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.jobsDescription.size());
		for (JobDescription entry : this.jobsDescription)
		{
			entry.serialize(writer);
		}
	}
}