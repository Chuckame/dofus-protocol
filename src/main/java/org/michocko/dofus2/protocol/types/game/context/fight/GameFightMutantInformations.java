package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.michocko.dofus2.protocol.types.game.character.status.PlayerStatus;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterNamedInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightMutantInformations extends GameFightFighterNamedInformations {
	public static final short TYPE_ID = 50;
	
	private byte powerLevel;
	
	public GameFightMutantInformations() {
	}
	
	public GameFightMutantInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats, String name, PlayerStatus status, byte powerLevel) {
		super(contextualId, look, disposition, teamId, wave, alive, stats, name, status);
		this.powerLevel = powerLevel;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.powerLevel = reader.readSByte();
		if (powerLevel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on powerLevel = %s, it doesn't respect the following condition : powerLevel < 0", powerLevel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.powerLevel);
	}
}