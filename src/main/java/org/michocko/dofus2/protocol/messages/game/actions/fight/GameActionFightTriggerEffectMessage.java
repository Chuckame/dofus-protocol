package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.messages.game.actions.fight.GameActionFightDispellEffectMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightTriggerEffectMessage extends GameActionFightDispellEffectMessage {
	public static final int MESSAGE_ID = 6147;
	
	
	public GameActionFightTriggerEffectMessage() {
	}
	
	public GameActionFightTriggerEffectMessage(short actionId, int sourceId, int targetId, int boostUID) {
		super(actionId, sourceId, targetId, boostUID);
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}