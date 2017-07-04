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
public class SkillActionDescriptionTimed extends SkillActionDescription {
	public static final short TYPE_ID = 103;
	
	private short time;
	
	public SkillActionDescriptionTimed() {
	}
	
	public SkillActionDescriptionTimed(short skillId, short time) {
		super(skillId);
		this.time = time;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.time = reader.readByte();
		if (time < 0 || time > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on time = %s, it doesn't respect the following condition : time < 0 || time > 255", time));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeByte(this.time);
	}
}