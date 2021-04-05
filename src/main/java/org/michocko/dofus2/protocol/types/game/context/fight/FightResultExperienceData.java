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
public class FightResultExperienceData extends FightResultAdditionalData {
	public static final short TYPE_ID = 192;
	
	private double experience;
	private double experienceLevelFloor;
	private double experienceNextLevelFloor;
	private int experienceFightDelta;
	private int experienceForGuild;
	private int experienceForMount;
	private int rerollExperienceMul;
	
	public FightResultExperienceData() {
	}
	
	public FightResultExperienceData(double experience, double experienceLevelFloor, double experienceNextLevelFloor, int experienceFightDelta, int experienceForGuild, int experienceForMount, int rerollExperienceMul) {
		this.experience = experience;
		this.experienceLevelFloor = experienceLevelFloor;
		this.experienceNextLevelFloor = experienceNextLevelFloor;
		this.experienceFightDelta = experienceFightDelta;
		this.experienceForGuild = experienceForGuild;
		this.experienceForMount = experienceForMount;
		this.rerollExperienceMul = rerollExperienceMul;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.experience = reader.readDouble();
		if (experience < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experience = %s, it doesn't respect the following condition : experience < 0", experience));
		this.experienceLevelFloor = reader.readDouble();
		if (experienceLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceLevelFloor = %s, it doesn't respect the following condition : experienceLevelFloor < 0", experienceLevelFloor));
		this.experienceNextLevelFloor = reader.readDouble();
		if (experienceNextLevelFloor < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceNextLevelFloor = %s, it doesn't respect the following condition : experienceNextLevelFloor < 0", experienceNextLevelFloor));
		this.experienceFightDelta = reader.readInt();
		this.experienceForGuild = reader.readInt();
		if (experienceForGuild < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceForGuild = %s, it doesn't respect the following condition : experienceForGuild < 0", experienceForGuild));
		this.experienceForMount = reader.readInt();
		if (experienceForMount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on experienceForMount = %s, it doesn't respect the following condition : experienceForMount < 0", experienceForMount));
		this.rerollExperienceMul = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeDouble(this.experience);
		writer.writeDouble(this.experienceLevelFloor);
		writer.writeDouble(this.experienceNextLevelFloor);
		writer.writeInt(this.experienceFightDelta);
		writer.writeInt(this.experienceForGuild);
		writer.writeInt(this.experienceForMount);
		writer.writeInt(this.rerollExperienceMul);
	}
}