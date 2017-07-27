package org.chuckame.dofus2.protocol.types.game.context.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightFighterLightInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GameFightFighterCompanionLightInformations extends GameFightFighterLightInformations {
	public static final short TYPE_ID = 454;
	
	private int companionId;
	private int masterId;
	
	public GameFightFighterCompanionLightInformations() {
	}
	
	public GameFightFighterCompanionLightInformations(int id, int wave, short level, byte breed, int companionId, int masterId) {
		super(id, wave, level, breed);
		this.companionId = companionId;
		this.masterId = masterId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.companionId = reader.readInt();
		this.masterId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.companionId);
		writer.writeInt(this.masterId);
	}
}