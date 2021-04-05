package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryListEntry;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobCrafterDirectoryAddMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5651;
	
	private JobCrafterDirectoryListEntry listEntry;
	
	public JobCrafterDirectoryAddMessage() {
	}
	
	public JobCrafterDirectoryAddMessage(JobCrafterDirectoryListEntry listEntry) {
		this.listEntry = listEntry;
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
		this.listEntry = new JobCrafterDirectoryListEntry();
		this.listEntry.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.listEntry.serialize(writer);
	}
}