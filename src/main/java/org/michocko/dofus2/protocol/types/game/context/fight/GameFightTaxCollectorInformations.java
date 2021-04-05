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
public class GameFightTaxCollectorInformations extends GameFightAIInformations {
	public static final short TYPE_ID = 48;
	
	private short firstNameId;
	private short lastNameId;
	private short level;
	
	public GameFightTaxCollectorInformations() {
	}
	
	public GameFightTaxCollectorInformations(int contextualId, EntityLook look, EntityDispositionInformations disposition, byte teamId, long wave, boolean alive, GameFightMinimalStats stats, short firstNameId, short lastNameId, short level) {
		super(contextualId, look, disposition, teamId, wave, alive, stats);
		this.firstNameId = firstNameId;
		this.lastNameId = lastNameId;
		this.level = level;
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
		this.level = reader.readShort();
		if (level < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on level = %s, it doesn't respect the following condition : level < 0", level));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.firstNameId);
		writer.writeShort(this.lastNameId);
		writer.writeShort(this.level);
	}
}