package org.chuckame.dofus2.protocol.types.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.actions.fight.AbstractFightDispellableEffect;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTemporarySpellImmunityEffect extends AbstractFightDispellableEffect {
	public static final short TYPE_ID = 366;
	
	private int immuneSpellId;
	
	public FightTemporarySpellImmunityEffect() {
	}
	
	public FightTemporarySpellImmunityEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, int immuneSpellId) {
		super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid);
		this.immuneSpellId = immuneSpellId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.immuneSpellId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.immuneSpellId);
	}
}