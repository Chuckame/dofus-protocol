package org.michocko.dofus2.protocol.types.game.actions.fight;

import org.michocko.dofus2.protocol.types.game.actions.fight.AbstractFightDispellableEffect;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTemporaryBoostEffect extends AbstractFightDispellableEffect {
	public static final short TYPE_ID = 209;
	
	private short delta;
	
	public FightTemporaryBoostEffect() {
	}
	
	public FightTemporaryBoostEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, short delta) {
		super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid);
		this.delta = delta;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.delta = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.delta);
	}
}