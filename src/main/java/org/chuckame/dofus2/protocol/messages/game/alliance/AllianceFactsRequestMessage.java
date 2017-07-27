package org.chuckame.dofus2.protocol.messages.game.alliance;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceFactsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6409;
	
	private int allianceId;
	
	public AllianceFactsRequestMessage() {
	}
	
	public AllianceFactsRequestMessage(int allianceId) {
		this.allianceId = allianceId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.allianceId = reader.readInt();
		if (allianceId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on allianceId = %s, it doesn't respect the following condition : allianceId < 0", allianceId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.allianceId);
	}
}