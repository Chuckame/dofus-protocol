package org.chuckame.dofus2.protocol.types.game.action.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.actions.fight.AbstractFightDispellableEffect;

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
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.actionId = reader.readShort();
		if (actionId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on actionId = %s, it doesn't respect the following condition : actionId < 0", actionId));
		this.sourceId = reader.readInt();
		this.effect = ProtocolTypeManager.getInstance().<AbstractFightDispellableEffect>newInstance(reader.readShort());
		this.effect.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.actionId);
		writer.writeInt(this.sourceId);
		writer.writeShort(this.effect.getProtocolTypeId());
		this.effect.serialize(writer);
	}
}