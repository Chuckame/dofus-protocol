package org.chuckame.dofus2.protocol.types.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightTeamInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightTeamMemberInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightAllianceTeamInformations extends FightTeamInformations {
	public static final short TYPE_ID = 439;
	
	private byte relation;
	
	public FightAllianceTeamInformations() {
	}
	
	public FightAllianceTeamInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId, long nbWaves, Collection<FightTeamMemberInformations> teamMembers, byte relation) {
		super(teamId, leaderId, teamSide, teamTypeId, nbWaves, teamMembers);
		this.relation = relation;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.relation = reader.readSByte();
		if (relation < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on relation = %s, it doesn't respect the following condition : relation < 0", relation));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.relation);
	}
}