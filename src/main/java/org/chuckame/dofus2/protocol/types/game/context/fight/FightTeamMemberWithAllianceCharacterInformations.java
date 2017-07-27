package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightTeamMemberCharacterInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicAllianceInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTeamMemberWithAllianceCharacterInformations extends FightTeamMemberCharacterInformations {
	public static final short TYPE_ID = 426;
	
	private BasicAllianceInformations allianceInfos;
	
	public FightTeamMemberWithAllianceCharacterInformations() {
	}
	
	public FightTeamMemberWithAllianceCharacterInformations(int id, String name, short level, BasicAllianceInformations allianceInfos) {
		super(id, name, level);
		this.allianceInfos = allianceInfos;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceInfos = new BasicAllianceInformations();
		this.allianceInfos.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.allianceInfos.serialize(writer);
	}
}