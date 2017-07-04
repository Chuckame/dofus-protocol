package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightResultAdditionalData;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightResultPvpData extends FightResultAdditionalData {
	public static final short TYPE_ID = 190;
	
	private short grade;
	private int minHonorForGrade;
	private int maxHonorForGrade;
	private int honor;
	private short honorDelta;
	
	public FightResultPvpData() {
	}
	
	public FightResultPvpData(short grade, int minHonorForGrade, int maxHonorForGrade, int honor, short honorDelta) {
		this.grade = grade;
		this.minHonorForGrade = minHonorForGrade;
		this.maxHonorForGrade = maxHonorForGrade;
		this.honor = honor;
		this.honorDelta = honorDelta;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.grade = reader.readByte();
		if (grade < 0 || grade > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on grade = %s, it doesn't respect the following condition : grade < 0 || grade > 255", grade));
		this.minHonorForGrade = reader.readUShort();
		if (minHonorForGrade < 0 || minHonorForGrade > 20000)
			throw new IllegalArgumentException(String.format("Forbidden value on minHonorForGrade = %s, it doesn't respect the following condition : minHonorForGrade < 0 || minHonorForGrade > 20000", minHonorForGrade));
		this.maxHonorForGrade = reader.readUShort();
		if (maxHonorForGrade < 0 || maxHonorForGrade > 20000)
			throw new IllegalArgumentException(String.format("Forbidden value on maxHonorForGrade = %s, it doesn't respect the following condition : maxHonorForGrade < 0 || maxHonorForGrade > 20000", maxHonorForGrade));
		this.honor = reader.readUShort();
		if (honor < 0 || honor > 20000)
			throw new IllegalArgumentException(String.format("Forbidden value on honor = %s, it doesn't respect the following condition : honor < 0 || honor > 20000", honor));
		this.honorDelta = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.grade);
		writer.writeUShort(this.minHonorForGrade);
		writer.writeUShort(this.maxHonorForGrade);
		writer.writeUShort(this.honor);
		writer.writeShort(this.honorDelta);
	}
}