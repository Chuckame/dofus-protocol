package org.michocko.dofus2.protocol.types.game.context.roleplay.job;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class JobExperience implements INetworkType {
	public static final short TYPE_ID = 98;
	
	private byte jobId;
	private byte jobLevel;
	private double jobXP;
	private double jobXpLevelFloor;
	private double jobXpNextLevelFloor;
	
	public JobExperience() {
	}
	
	public JobExperience(byte jobId, byte jobLevel, double jobXP, double jobXpLevelFloor, double jobXpNextLevelFloor) {
		this.jobId = jobId;
		this.jobLevel = jobLevel;
		this.jobXP = jobXP;
		this.jobXpLevelFloor = jobXpLevelFloor;
		this.jobXpNextLevelFloor = jobXpNextLevelFloor;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.jobId = reader.readSByte();
		if (jobId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobId = %s, it doesn't respect the following condition : jobId < 0", jobId));
		this.jobLevel = reader.readSByte();
		if (jobLevel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobLevel = %s, it doesn't respect the following condition : jobLevel < 0", jobLevel));
		this.jobXP = reader.readDouble();
		if (jobXP < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobXP = %s, it doesn't respect the following condition : jobXP < 0", jobXP));
		this.jobXpLevelFloor = reader.readDouble();
		if (jobXpLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobXpLevelFloor = %s, it doesn't respect the following condition : jobXpLevelFloor < 0", jobXpLevelFloor));
		this.jobXpNextLevelFloor = reader.readDouble();
		if (jobXpNextLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on jobXpNextLevelFloor = %s, it doesn't respect the following condition : jobXpNextLevelFloor < 0", jobXpNextLevelFloor));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.jobId);
		writer.writeSByte(this.jobLevel);
		writer.writeDouble(this.jobXP);
		writer.writeDouble(this.jobXpLevelFloor);
		writer.writeDouble(this.jobXpNextLevelFloor);
	}
}