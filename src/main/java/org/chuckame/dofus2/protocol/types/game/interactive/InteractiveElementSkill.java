package org.chuckame.dofus2.protocol.types.game.interactive;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class InteractiveElementSkill implements INetworkType {
	public static final short TYPE_ID = 219;
	
	private int skillId;
	private int skillInstanceUid;
	
	public InteractiveElementSkill() {
	}
	
	public InteractiveElementSkill(int skillId, int skillInstanceUid) {
		this.skillId = skillId;
		this.skillInstanceUid = skillInstanceUid;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.skillId = reader.readInt();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
		this.skillInstanceUid = reader.readInt();
		if (skillInstanceUid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillInstanceUid = %s, it doesn't respect the following condition : skillInstanceUid < 0", skillInstanceUid));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.skillId);
		writer.writeInt(this.skillInstanceUid);
	}
}