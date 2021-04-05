package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.look.EntityLook;
import org.michocko.dofus2.protocol.types.game.context.EntityDispositionInformations;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightMinimalStats;
import org.michocko.dofus2.protocol.types.game.context.fight.GameFightAIInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightMonsterInformations extends GameFightAIInformations {
	public static final short TYPE_ID = 29;
	
	private short creatureGenericId;
	private byte creatureGrade;
	
	public GameFightMonsterInformations() {
	}
	
	public GameFightMonsterInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats, short creatureGenericId, byte creatureGrade) {
		super(contextualId, look, disposition, teamId, wave, alive, stats);
		this.creatureGenericId = creatureGenericId;
		this.creatureGrade = creatureGrade;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.creatureGenericId = reader.readShort();
		if (creatureGenericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on creatureGenericId = %s, it doesn't respect the following condition : creatureGenericId < 0", creatureGenericId));
		this.creatureGrade = reader.readSByte();
		if (creatureGrade < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on creatureGrade = %s, it doesn't respect the following condition : creatureGrade < 0", creatureGrade));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.creatureGenericId);
		writer.writeSByte(this.creatureGrade);
	}
}