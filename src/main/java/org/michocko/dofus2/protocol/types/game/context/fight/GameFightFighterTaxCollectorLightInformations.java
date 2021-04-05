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
public class GameFightFighterTaxCollectorLightInformations extends GameFightFighterLightInformations {
	public static final short TYPE_ID = 457;
	
	private short firstNameId;
	private short lastNameId;
	
	public GameFightFighterTaxCollectorLightInformations() {
	}
	
	public GameFightFighterTaxCollectorLightInformations(int id, int wave, short level, byte breed, short firstNameId, short lastNameId) {
		super(id, wave, level, breed);
		this.firstNameId = firstNameId;
		this.lastNameId = lastNameId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.firstNameId = reader.readShort();
		if (firstNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firstNameId = %s, it doesn't respect the following condition : firstNameId < 0", firstNameId));
		this.lastNameId = reader.readShort();
		if (lastNameId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastNameId = %s, it doesn't respect the following condition : lastNameId < 0", lastNameId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.firstNameId);
		writer.writeShort(this.lastNameId);
	}
}