package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.messages.game.actions.AbstractGameActionMessage;
import org.chuckame.dofus2.protocol.types.game.actions.fight.AbstractFightDispellableEffect;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightDispellableEffectMessage extends AbstractGameActionMessage {
	public static final int MESSAGE_ID = 6070;
	
	private AbstractFightDispellableEffect effect;
	
	public GameActionFightDispellableEffectMessage() {
	}
	
	public GameActionFightDispellableEffectMessage(short actionId, int sourceId, AbstractFightDispellableEffect effect) {
		super(actionId, sourceId);
		this.effect = effect;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.effect = ProtocolTypeManager.getInstance().<AbstractFightDispellableEffect>newInstance(reader.readShort());
		this.effect.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.effect.getProtocolTypeId());
		this.effect.serialize(writer);
	}
}