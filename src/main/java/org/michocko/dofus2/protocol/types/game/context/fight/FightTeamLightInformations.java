package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.AbstractFightTeamInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTeamLightInformations extends AbstractFightTeamInformations {
	public static final short TYPE_ID = 115;
	
	private byte teamMembersCount;
	private int meanLevel;
	
	public FightTeamLightInformations() {
	}
	
	public FightTeamLightInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId, long nbWaves, byte teamMembersCount, int meanLevel) {
		super(teamId, leaderId, teamSide, teamTypeId, nbWaves);
		this.teamMembersCount = teamMembersCount;
		this.meanLevel = meanLevel;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.teamMembersCount = reader.readSByte();
		if (teamMembersCount < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on teamMembersCount = %s, it doesn't respect the following condition : teamMembersCount < 0", teamMembersCount));
		this.meanLevel = reader.readInt();
		if (meanLevel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on meanLevel = %s, it doesn't respect the following condition : meanLevel < 0", meanLevel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.teamMembersCount);
		writer.writeInt(this.meanLevel);
	}
}