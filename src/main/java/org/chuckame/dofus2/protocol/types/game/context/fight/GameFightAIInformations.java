package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.chuckame.dofus2.protocol.types.game.look.EntityLook;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightAIInformations extends GameFightFighterInformations {
	public static final short TYPE_ID = 151;
	
	
	public GameFightAIInformations() {
	}
	
	public GameFightAIInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats) {
		super(contextualId, look, disposition, teamId, wave, alive, stats);
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}