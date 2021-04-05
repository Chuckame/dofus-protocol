package org.michocko.dofus2.protocol.types.game.interactive.skill;

import org.michocko.dofus2.protocol.types.game.interactive.skill.SkillActionDescription;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class SkillActionDescriptionCraft extends SkillActionDescription {
	public static final short TYPE_ID = 100;
	
	private byte maxSlots;
	private byte probability;
	
	public SkillActionDescriptionCraft() {
	}
	
	public SkillActionDescriptionCraft(short skillId, byte maxSlots, byte probability) {
		super(skillId);
		this.maxSlots = maxSlots;
		this.probability = probability;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.maxSlots = reader.readSByte();
		if (maxSlots < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxSlots = %s, it doesn't respect the following condition : maxSlots < 0", maxSlots));
		this.probability = reader.readSByte();
		if (probability < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on probability = %s, it doesn't respect the following condition : probability < 0", probability));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.maxSlots);
		writer.writeSByte(this.probability);
	}
}