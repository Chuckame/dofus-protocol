package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MapRunningFightDetailsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5750;
	
	private int fightId;
	
	public MapRunningFightDetailsRequestMessage() {
	}
	
	public MapRunningFightDetailsRequestMessage(int fightId) {
		this.fightId = fightId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.fightId = reader.readInt();
		if (fightId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on fightId = %s, it doesn't respect the following condition : fightId < 0", fightId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.fightId);
	}
}