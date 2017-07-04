package org.michocko.dofus2.protocol.messages.game.actions.fight;

import org.michocko.dofus2.protocol.messages.game.actions.fight.GameActionFightLifePointsLostMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameActionFightLifeAndShieldPointsLostMessage extends GameActionFightLifePointsLostMessage {
	public static final int MESSAGE_ID = 6310;
	
	private short shieldLoss;
	
	public GameActionFightLifeAndShieldPointsLostMessage() {
	}
	
	public GameActionFightLifeAndShieldPointsLostMessage(short actionId, int sourceId, int targetId, short loss, short permanentDamages, short shieldLoss) {
		super(actionId, sourceId, targetId, loss, permanentDamages);
		this.shieldLoss = shieldLoss;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.shieldLoss = reader.readShort();
		if (shieldLoss < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on shieldLoss = %s, it doesn't respect the following condition : shieldLoss < 0", shieldLoss));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.shieldLoss);
	}
}