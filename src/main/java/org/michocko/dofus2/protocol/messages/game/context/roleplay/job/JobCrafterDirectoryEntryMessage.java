package org.michocko.dofus2.protocol.messages.game.context.roleplay.job;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryEntryPlayerInfo;
import org.michocko.dofus2.protocol.types.game.context.roleplay.job.JobCrafterDirectoryEntryJobInfo;
import org.michocko.dofus2.protocol.types.game.look.EntityLook;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class JobCrafterDirectoryEntryMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6044;
	
	private JobCrafterDirectoryEntryPlayerInfo playerInfo;
	private Collection<JobCrafterDirectoryEntryJobInfo> jobInfoList;
	private EntityLook playerLook;
	
	public JobCrafterDirectoryEntryMessage() {
	}
	
	public JobCrafterDirectoryEntryMessage(JobCrafterDirectoryEntryPlayerInfo playerInfo, Collection<JobCrafterDirectoryEntryJobInfo> jobInfoList, EntityLook playerLook) {
		this.playerInfo = playerInfo;
		this.jobInfoList = jobInfoList;
		this.playerLook = playerLook;
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
		this.playerInfo = new JobCrafterDirectoryEntryPlayerInfo();
		this.playerInfo.deserialize(reader);
		int length = reader.readUShort();
		this.jobInfoList = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			JobCrafterDirectoryEntryJobInfo entry = new JobCrafterDirectoryEntryJobInfo();
			entry.deserialize(reader);
			this.jobInfoList.add(entry);
		}
		this.playerLook = new EntityLook();
		this.playerLook.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.playerInfo.serialize(writer);
		writer.writeUShort(this.jobInfoList.size());
		for (JobCrafterDirectoryEntryJobInfo entry : this.jobInfoList)
		{
			entry.serialize(writer);
		}
		this.playerLook.serialize(writer);
	}
}