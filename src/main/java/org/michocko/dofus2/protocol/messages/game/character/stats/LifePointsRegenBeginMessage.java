package org.michocko.dofus2.protocol.messages.game.character.stats;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.regenRate = reader.readByte();
		if (regenRate < 0 || regenRate > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on regenRate = %s, it doesn't respect the following condition : regenRate < 0 || regenRate > 255", regenRate));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeByte(this.regenRate);
	}
}