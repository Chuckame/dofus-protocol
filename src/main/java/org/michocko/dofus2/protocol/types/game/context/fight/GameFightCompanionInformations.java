package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightCompanionInformations extends GameFightFighterInformations {
	public static final short TYPE_ID = 450;
	
	private short companionGenericId;
	private short level;
	private int masterId;
	
	public GameFightCompanionInformations() {
	}
	
	public GameFightCompanionInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats, short companionGenericId, short level, int masterId) {
		super(contextualId, look, disposition, teamId, wave, alive, stats);
		this.companionGenericId = companionGenericId;
		this.level = level;
		this.masterId = masterId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.companionGenericId = reader.readShort();
		if (companionGenericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on companionGenericId = %s, it doesn't respect the following condition : companionGenericId < 0", companionGenericId));
		this.level = reader.readShort();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
		this.masterId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.companionGenericId);
		writer.writeShort(this.level);
		writer.writeInt(this.masterId);
	}
}