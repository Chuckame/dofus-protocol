package org.chuckame.dofus2.protocol.messages.game.context.roleplay.stats;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.nbCharacBoost = reader.readShort();
		if (nbCharacBoost < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbCharacBoost = %s, it doesn't respect the following condition : nbCharacBoost < 0", nbCharacBoost));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.nbCharacBoost);
	}
}