package org.chuckame.dofus2.protocol.messages.game.actions.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.actions.fight.AbstractGameActionFightTargetedAbilityMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightCloseCombatMessage extends AbstractGameActionFightTargetedAbilityMessage {
	public static final int MESSAGE_ID = 6116;
	
	private int weaponGenericId;
	
	public GameActionFightCloseCombatMessage() {
	}
	
	public GameActionFightCloseCombatMessage(short actionId, int sourceId, int targetId, short destinationCellId, byte critical, boolean silentCast, int weaponGenericId) {
		super(actionId, sourceId, targetId, destinationCellId, critical, silentCast);
		this.weaponGenericId = weaponGenericId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.weaponGenericId = reader.readInt();
		if (weaponGenericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on weaponGenericId = %s, it doesn't respect the following condition : weaponGenericId < 0", weaponGenericId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.weaponGenericId);
	}
}