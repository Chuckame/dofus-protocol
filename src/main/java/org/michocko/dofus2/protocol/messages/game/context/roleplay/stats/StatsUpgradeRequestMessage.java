package org.michocko.dofus2.protocol.messages.game.context.roleplay.stats;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class StatsUpgradeRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5610;
	
	private byte statId;
	private short boostPoint;
	
	public StatsUpgradeRequestMessage() {
	}
	
	public StatsUpgradeRequestMessage(byte statId, short boostPoint) {
		this.statId = statId;
		this.boostPoint = boostPoint;
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
		this.statId = reader.readSByte();
		if (statId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on statId = %s, it doesn't respect the following condition : statId < 0", statId));
		this.boostPoint = reader.readShort();
		if (boostPoint < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on boostPoint = %s, it doesn't respect the following condition : boostPoint < 0", boostPoint));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.statId);
		writer.writeShort(this.boostPoint);
	}
}