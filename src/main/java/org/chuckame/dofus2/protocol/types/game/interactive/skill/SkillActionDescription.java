package org.chuckame.dofus2.protocol.types.game.interactive.skill;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

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
	
	public short getProtocolTypeId() {
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