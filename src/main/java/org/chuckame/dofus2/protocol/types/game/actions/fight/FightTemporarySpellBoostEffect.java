package org.chuckame.dofus2.protocol.types.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.actions.fight.FightTemporaryBoostEffect;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTemporarySpellBoostEffect extends FightTemporaryBoostEffect {
	public static final short TYPE_ID = 207;
	
	private short boostedSpellId;
	
	public FightTemporarySpellBoostEffect() {
	}
	
	public FightTemporarySpellBoostEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, short delta, short boostedSpellId) {
		super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta);
		this.boostedSpellId = boostedSpellId;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.boostedSpellId = reader.readShort();
		if (boostedSpellId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on boostedSpellId = %s, it doesn't respect the following condition : boostedSpellId < 0", boostedSpellId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.boostedSpellId);
	}
}