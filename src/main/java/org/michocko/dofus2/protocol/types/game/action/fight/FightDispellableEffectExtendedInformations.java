package org.michocko.dofus2.protocol.types.game.action.fight;

import org.michocko.dofus2.protocol.types.game.actions.fight.AbstractFightDispellableEffect;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkType;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class FightDispellableEffectExtendedInformations implements INetworkType {
	public static final short TYPE_ID = 208;
	
	private short actionId;
	private int sourceId;
	private AbstractFightDispellableEffect effect;
	
	public FightDispellableEffectExtendedInformations() {
	}
	
	public FightDispellableEffectExtendedInformations(short actionId, int sourceId, AbstractFightDispellableEffect effect) {
		this.actionId = actionId;
		this.sourceId = sourceId;
		this.effect = effect;
	}
	
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.actionId = reader.readShort();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
		this.sourceId = reader.readInt();
		this.effect = (AbstractFightDispellableEffect) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.effect.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.actionId);
		writer.writeInt(this.sourceId);
		writer.writeShort(this.effect.getNetworkTypeId());
		this.effect.serialize(writer);
	}
}