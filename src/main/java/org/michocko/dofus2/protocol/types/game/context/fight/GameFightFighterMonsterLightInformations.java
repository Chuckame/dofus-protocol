package org.michocko.dofus2.protocol.types.game.context.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterLightInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightFighterMonsterLightInformations extends GameFightFighterLightInformations {
	public static final short TYPE_ID = 455;
	
	private short creatureGenericId;
	
	public GameFightFighterMonsterLightInformations() {
	}
	
	public GameFightFighterMonsterLightInformations(int id, int wave, short level, byte breed, short creatureGenericId) {
		super(id, wave, level, breed);
		this.creatureGenericId = creatureGenericId;
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
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.creatureGenericId);
	}
}