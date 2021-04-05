package org.michocko.dofus2.protocol.types.game.context.fight;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.fight.FightTeamMemberInformations;
import org.michocko.dofus2.protocol.types.game.context.fight.AbstractFightTeamInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		int length = reader.readUShort();
		this.teamMembers = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightTeamMemberInformations entry = (FightTeamMemberInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
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
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}