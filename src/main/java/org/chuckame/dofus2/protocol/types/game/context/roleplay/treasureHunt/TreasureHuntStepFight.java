package org.chuckame.dofus2.protocol.types.game.context.roleplay.treasureHunt;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.treasureHunt.TreasureHuntStep;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class TreasureHuntStepFight extends TreasureHuntStep {
	public static final short TYPE_ID = 462;
	
	
	public TreasureHuntStepFight() {
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