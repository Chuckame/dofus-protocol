package org.chuckame.dofus2.protocol.messages.game.character.stats;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.character.stats.UpdateLifePointsMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class LifePointsRegenEndMessage extends UpdateLifePointsMessage {
	public static final int MESSAGE_ID = 5686;
	
	private int lifePointsGained;
	
	public LifePointsRegenEndMessage() {
	}
	
	public LifePointsRegenEndMessage(int lifePoints, int maxLifePoints, int lifePointsGained) {
		super(lifePoints, maxLifePoints);
		this.lifePointsGained = lifePointsGained;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.lifePointsGained = reader.readInt();
		if (lifePointsGained < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lifePointsGained = %s, it doesn't respect the following condition : lifePointsGained < 0", lifePointsGained));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.lifePointsGained);
	}
}