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
public class TreasureHuntStepFollowDirectionToPOI extends TreasureHuntStep {
	public static final short TYPE_ID = 461;
	
	private byte direction;
	private int poiLabelId;
	
	public TreasureHuntStepFollowDirectionToPOI() {
	}
	
	public TreasureHuntStepFollowDirectionToPOI(byte direction, int poiLabelId) {
		this.direction = direction;
		this.poiLabelId = poiLabelId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.direction = reader.readSByte();
		if (direction < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on direction = %s, it doesn't respect the following condition : direction < 0", direction));
		this.poiLabelId = reader.readInt();
		if (poiLabelId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on poiLabelId = %s, it doesn't respect the following condition : poiLabelId < 0", poiLabelId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.direction);
		writer.writeInt(this.poiLabelId);
	}
}