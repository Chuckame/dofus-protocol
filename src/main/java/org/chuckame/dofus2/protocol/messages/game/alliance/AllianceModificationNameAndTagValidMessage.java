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
public class AllianceModificationNameAndTagValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6449;
	
	private String allianceName;
	private String allianceTag;
	
	public AllianceModificationNameAndTagValidMessage() {
	}
	
	public AllianceModificationNameAndTagValidMessage(String allianceName, String allianceTag) {
		this.allianceName = allianceName;
		this.allianceTag = allianceTag;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.allianceName = reader.readUTF();
		this.allianceTag = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.allianceName);
		writer.writeUTF(this.allianceTag);
	}
}