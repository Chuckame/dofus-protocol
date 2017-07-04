package org.michocko.dofus2.protocol.types.game.interactive.skill;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class SkillActionDescription implements INetworkType {
	public static final short TYPE_ID = 102;
	
	private short skillId;
	
	public SkillActionDescription() {
	}
	
	public SkillActionDescription(short skillId) {
		this.skillId = skillId;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.skillId = reader.readShort();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.skillId);
	}
}