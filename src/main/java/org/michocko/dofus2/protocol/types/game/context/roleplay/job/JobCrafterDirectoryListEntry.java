package org.michocko.dofus2.protocol.types.game.context.roleplay.job;

import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryEntryPlayerInfo;
import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryEntryJobInfo;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class JobCrafterDirectoryListEntry implements INetworkType {
	public static final short TYPE_ID = 196;
	
	private JobCrafterDirectoryEntryPlayerInfo playerInfo;
	private JobCrafterDirectoryEntryJobInfo jobInfo;
	
	public JobCrafterDirectoryListEntry() {
	}
	
	public JobCrafterDirectoryListEntry(JobCrafterDirectoryEntryPlayerInfo playerInfo, JobCrafterDirectoryEntryJobInfo jobInfo) {
		this.playerInfo = playerInfo;
		this.jobInfo = jobInfo;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
		this.playerInfo.deserialize(reader);
		this.jobInfo = new JobCrafterDirectoryEntryJobInfo();
		this.jobInfo.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.playerInfo.serialize(writer);
		this.jobInfo.serialize(writer);
	}
}