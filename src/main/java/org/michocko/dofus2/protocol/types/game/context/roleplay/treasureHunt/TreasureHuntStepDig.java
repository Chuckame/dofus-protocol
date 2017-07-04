package org.michocko.dofus2.protocol.types.game.context.roleplay.treasureHunt;

import org.michocko.dofus2.protocol.types.game.context.roleplay.treasureHunt.TreasureHuntStep;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class TreasureHuntStepDig extends TreasureHuntStep {
	public static final short TYPE_ID = 465;
	
	
	public TreasureHuntStepDig() {
	}
	
	
	@Override
	public short getNetworkTypeId() {
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