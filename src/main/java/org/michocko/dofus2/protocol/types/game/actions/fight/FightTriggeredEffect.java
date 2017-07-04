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
public class FightTriggeredEffect extends AbstractFightDispellableEffect {
	public static final short TYPE_ID = 210;
	
	private int arg1;
	private int arg2;
	private int arg3;
	private short delay;
	
	public FightTriggeredEffect() {
	}
	
	public FightTriggeredEffect(int uid, int targetId, short turnDuration, byte dispelable, short spellId, int parentBoostUid, int arg1, int arg2, int arg3, short delay) {
		super(uid, targetId, turnDuration, dispelable, spellId, parentBoostUid);
		this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
		this.delay = delay;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.arg1 = reader.readInt();
		this.arg2 = reader.readInt();
		this.arg3 = reader.readInt();
		this.delay = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.arg1);
		writer.writeInt(this.arg2);
		writer.writeInt(this.arg3);
		writer.writeShort(this.delay);
	}
}