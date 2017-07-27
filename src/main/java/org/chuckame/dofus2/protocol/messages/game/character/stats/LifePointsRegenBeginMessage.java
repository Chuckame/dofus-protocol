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
public class LifePointsRegenBeginMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5684;
	
	private short regenRate;
	
	public LifePointsRegenBeginMessage() {
	}
	
	public LifePointsRegenBeginMessage(short regenRate) {
		this.regenRate = regenRate;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.regenRate = reader.readByte();
		if (regenRate < 0 || regenRate > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on regenRate = %s, it doesn't respect the following condition : regenRate < 0 || regenRate > 255", regenRate));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.regenRate);
	}
}