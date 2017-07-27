package org.chuckame.dofus2.protocol.messages.game.character.stats;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class UpdateLifePointsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5658;
	
	private int lifePoints;
	private int maxLifePoints;
	
	public UpdateLifePointsMessage() {
	}
	
	public UpdateLifePointsMessage(int lifePoints, int maxLifePoints) {
		this.lifePoints = lifePoints;
		this.maxLifePoints = maxLifePoints;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.lifePoints = reader.readInt();
		if (lifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lifePoints = %s, it doesn't respect the following condition : lifePoints < 0", lifePoints));
		this.maxLifePoints = reader.readInt();
		if (maxLifePoints < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxLifePoints = %s, it doesn't respect the following condition : maxLifePoints < 0", maxLifePoints));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.lifePoints);
		writer.writeInt(this.maxLifePoints);
	}
}