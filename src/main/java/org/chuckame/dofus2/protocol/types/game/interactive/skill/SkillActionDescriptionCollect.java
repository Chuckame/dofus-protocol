package org.chuckame.dofus2.protocol.types.game.interactive.skill;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.interactive.skill.SkillActionDescriptionTimed;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class SkillActionDescriptionCollect extends SkillActionDescriptionTimed {
	public static final short TYPE_ID = 99;
	
	private short min;
	private short max;
	
	public SkillActionDescriptionCollect() {
	}
	
	public SkillActionDescriptionCollect(short skillId, short time, short min, short max) {
		super(skillId, time);
		this.min = min;
		this.max = max;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.min = reader.readShort();
		if (min < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on min = %s, it doesn't respect the following condition : min < 0", min));
		this.max = reader.readShort();
		if (max < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on max = %s, it doesn't respect the following condition : max < 0", max));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.min);
		writer.writeShort(this.max);
	}
}