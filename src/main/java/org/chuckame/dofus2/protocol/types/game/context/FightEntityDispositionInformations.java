package org.chuckame.dofus2.protocol.types.game.context;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.EntityDispositionInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightEntityDispositionInformations extends EntityDispositionInformations {
	public static final short TYPE_ID = 217;
	
	private int carryingCharacterId;
	
	public FightEntityDispositionInformations() {
	}
	
	public FightEntityDispositionInformations(short cellId, byte direction, int carryingCharacterId) {
		super(cellId, direction);
		this.carryingCharacterId = carryingCharacterId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.carryingCharacterId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.carryingCharacterId);
	}
}