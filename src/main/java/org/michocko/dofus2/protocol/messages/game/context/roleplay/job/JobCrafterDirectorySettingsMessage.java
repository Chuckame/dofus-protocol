package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectorySettings;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobCrafterDirectorySettingsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5652;
	
	private Collection<JobCrafterDirectorySettings> craftersSettings;
	
	public JobCrafterDirectorySettingsMessage() {
	}
	
	public JobCrafterDirectorySettingsMessage(Collection<JobCrafterDirectorySettings> craftersSettings) {
		this.craftersSettings = craftersSettings;
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
		this.craftersSettings = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			JobCrafterDirectorySettings entry = new JobCrafterDirectorySettings();
			entry.deserialize(reader);
			this.craftersSettings.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.craftersSettings.size());
		for (JobCrafterDirectorySettings entry : this.craftersSettings)
		{
			entry.serialize(writer);
		}
	}
}