package org.chuckame.dofus2.protocol.types.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryEntryJobInfo;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryEntryPlayerInfo;

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
	
	public short getProtocolTypeId() {
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