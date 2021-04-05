package org.michocko.dofus2.protocol.types.game.interactive;

import org.michocko.dofus2.protocol.types.game.interactive.InteractiveElementSkill;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class InteractiveElementNamedSkill extends InteractiveElementSkill {
	public static final short TYPE_ID = 220;
	
	private int nameId;
	
	public InteractiveElementNamedSkill() {
	}
	
	public InteractiveElementNamedSkill(int skillId, int skillInstanceUid, int nameId) {
		super(skillId, skillInstanceUid);
		this.nameId = nameId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.nameId = reader.readInt();
		if (nameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nameId = %s, it doesn't respect the following condition : nameId < 0", nameId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.nameId);
	}
}