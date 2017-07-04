package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightTeamMemberInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTeamMemberCharacterInformations extends FightTeamMemberInformations {
	public static final short TYPE_ID = 13;
	
	private String name;
	private short level;
	
	public FightTeamMemberCharacterInformations() {
	}
	
	public FightTeamMemberCharacterInformations(int id, String name, short level) {
		super(id);
		this.name = name;
		this.level = level;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.name = reader.readUTF();
		this.level = reader.readShort();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.name);
		writer.writeShort(this.level);
	}
}