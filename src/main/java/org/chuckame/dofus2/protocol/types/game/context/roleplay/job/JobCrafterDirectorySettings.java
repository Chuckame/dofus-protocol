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
public class JobCrafterDirectorySettings implements INetworkType {
	public static final short TYPE_ID = 97;
	
	private byte jobId;
	private byte minSlot;
	private byte userDefinedParams;
	
	public JobCrafterDirectorySettings() {
	}
	
	public JobCrafterDirectorySettings(byte jobId, byte minSlot, byte userDefinedParams) {
		this.jobId = jobId;
		this.minSlot = minSlot;
		this.userDefinedParams = userDefinedParams;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.jobId = reader.readSByte();
		if (jobId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobId = %s, it doesn't respect the following condition : jobId < 0", jobId));
		this.minSlot = reader.readSByte();
		if (minSlot < 0 || minSlot > 9)
			throw new IllegalArgumentException(String.format("Forbidden value on minSlot = %s, it doesn't respect the following condition : minSlot < 0 || minSlot > 9", minSlot));
		this.userDefinedParams = reader.readSByte();
		if (userDefinedParams < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on userDefinedParams = %s, it doesn't respect the following condition : userDefinedParams < 0", userDefinedParams));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.jobId);
		writer.writeSByte(this.minSlot);
		writer.writeSByte(this.userDefinedParams);
	}
}