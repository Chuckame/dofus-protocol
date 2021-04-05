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
public class StatsUpgradeResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5609;
	
	private short nbCharacBoost;
	
	public StatsUpgradeResultMessage() {
	}
	
	public StatsUpgradeResultMessage(short nbCharacBoost) {
		this.nbCharacBoost = nbCharacBoost;
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
		this.nbCharacBoost = reader.readShort();
		if (nbCharacBoost < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbCharacBoost = %s, it doesn't respect the following condition : nbCharacBoost < 0", nbCharacBoost));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.nbCharacBoost);
	}
}