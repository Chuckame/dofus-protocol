package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	public int getNetworkMessageId() {
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