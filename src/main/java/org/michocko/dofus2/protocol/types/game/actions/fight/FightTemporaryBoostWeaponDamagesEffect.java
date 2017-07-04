package org.michocko.dofus2.protocol.types.game.actions.fight;

import org.michocko.dofus2.protocol.types.game.actions.fight.FightTemporaryBoostEffect;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class FightTemporaryBoostWeaponDamagesEffect extends FightTemporaryBoostEffect {
	public static final short TYPE_ID = 211;
	
	private short weaponTypeId;
	
	public FightTemporaryBoostWeaponDamagesEffect() {
	}
	
	public FightTemporaryBoostWeaponDamagesEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, short delta, short weaponTypeId) {
		super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid, delta);
		this.weaponTypeId = weaponTypeId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.weaponTypeId = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.weaponTypeId);
	}
}