package org.chuckame.dofus2.protocol.types.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.fight.AbstractFightTeamInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightTeamMemberInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTeamInformations extends AbstractFightTeamInformations {
	public static final short TYPE_ID = 33;
	
	private Collection<FightTeamMemberInformations> teamMembers;
	
	public FightTeamInformations() {
	}
	
	public FightTeamInformations(byte teamId, int leaderId, byte teamSide, byte teamTypeId, long nbWaves, Collection<FightTeamMemberInformations> teamMembers) {
		super(teamId, leaderId, teamSide, teamTypeId, nbWaves);
		this.teamMembers = teamMembers;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.teamMembers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightTeamMemberInformations entry = ProtocolTypeManager.getInstance().<FightTeamMemberInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.teamMembers.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.teamMembers.size());
		for (FightTeamMemberInformations entry : this.teamMembers)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
	}
}