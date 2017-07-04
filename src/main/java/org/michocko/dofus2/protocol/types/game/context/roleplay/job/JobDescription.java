package org.michocko.dofus2.protocol.types.game.context.roleplay.job;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.interactive.skill.SkillActionDescription;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class JobDescription implements INetworkType {
	public static final short TYPE_ID = 101;
	
	private byte jobId;
	private Collection<SkillActionDescription> skills;
	
	public JobDescription() {
	}
	
	public JobDescription(byte jobId, Collection<SkillActionDescription> skills) {
		this.jobId = jobId;
		this.skills = skills;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.jobId = reader.readSByte();
		if (jobId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobId = %s, it doesn't respect the following condition : jobId < 0", jobId));
		int length = reader.readUShort();
		this.skills = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			SkillActionDescription entry = ProtocolTypeManager.getInstance().<SkillActionDescription>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.skills.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.jobId);
		writer.writeUShort(this.skills.size());
		for (SkillActionDescription entry : this.skills)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}