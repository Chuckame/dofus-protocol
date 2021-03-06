package org.chuckame.dofus2.protocol.messages.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryListEntry;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.listEntry = new JobCrafterDirectoryListEntry();
		this.listEntry.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.listEntry.serialize(writer);
	}
}