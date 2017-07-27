package org.chuckame.dofus2.protocol.types.game.context.roleplay.job;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class JobCrafterDirectoryEntryJobInfo implements INetworkType {
	public static final short TYPE_ID = 195;
	
	private byte jobId;
	private byte jobLevel;
	private byte userDefinedParams;
	private byte minSlots;
	
	public JobCrafterDirectoryEntryJobInfo() {
	}
	
	public JobCrafterDirectoryEntryJobInfo(byte jobId, byte jobLevel, byte userDefinedParams, byte minSlots) {
		this.jobId = jobId;
		this.jobLevel = jobLevel;
		this.userDefinedParams = userDefinedParams;
		this.minSlots = minSlots;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.jobId = reader.readSByte();
		if (jobId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobId = %s, it doesn't respect the following condition : jobId < 0", jobId));
		this.jobLevel = reader.readSByte();
		if (jobLevel < 1 || jobLevel > 100)
			throw new IllegalArgumentException(String.format("Forbidden value on jobLevel = %s, it doesn't respect the following condition : jobLevel < 1 || jobLevel > 100", jobLevel));
		this.userDefinedParams = reader.readSByte();
		if (userDefinedParams < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on userDefinedParams = %s, it doesn't respect the following condition : userDefinedParams < 0", userDefinedParams));
		this.minSlots = reader.readSByte();
		if (minSlots < 0 || minSlots > 9)
			throw new IllegalArgumentException(String.format("Forbidden value on minSlots = %s, it doesn't respect the following condition : minSlots < 0 || minSlots > 9", minSlots));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.jobId);
		writer.writeSByte(this.jobLevel);
		writer.writeSByte(this.userDefinedParams);
		writer.writeSByte(this.minSlots);
	}
}