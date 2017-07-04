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
public class FightTeamMemberMonsterInformations extends FightTeamMemberInformations {
	public static final short TYPE_ID = 6;
	
	private int monsterId;
	private byte grade;
	
	public FightTeamMemberMonsterInformations() {
	}
	
	public FightTeamMemberMonsterInformations(int id, int monsterId, byte grade) {
		super(id);
		this.monsterId = monsterId;
		this.grade = grade;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.monsterId = reader.readInt();
		this.grade = reader.readSByte();
		if (grade < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on grade = %s, it doesn't respect the following condition : grade < 0", grade));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.monsterId);
		writer.writeSByte(this.grade);
	}
}