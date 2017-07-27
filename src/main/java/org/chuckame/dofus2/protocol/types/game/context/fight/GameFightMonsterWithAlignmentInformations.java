package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.character.alignment.ActorAlignmentInformations;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightMonsterInformations;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightMonsterWithAlignmentInformations extends GameFightMonsterInformations {
	public static final short TYPE_ID = 203;
	
	private ActorAlignmentInformations alignmentInfos;
	
	public GameFightMonsterWithAlignmentInformations() {
	}
	
	public GameFightMonsterWithAlignmentInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats, short creatureGenericId, byte creatureGrade, ActorAlignmentInformations alignmentInfos) {
		super(contextualId, look, disposition, teamId, wave, alive, stats, creatureGenericId, creatureGrade);
		this.alignmentInfos = alignmentInfos;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.alignmentInfos = new ActorAlignmentInformations();
		this.alignmentInfos.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.alignmentInfos.serialize(writer);
	}
}