package org.chuckame.dofus2.protocol.messages.game.alliance;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.social.AllianceFactSheetInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6408;
	
	private Collection<AllianceFactSheetInformations> alliances;
	
	public AllianceListMessage() {
	}
	
	public AllianceListMessage(Collection<AllianceFactSheetInformations> alliances) {
		this.alliances = alliances;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.alliances = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AllianceFactSheetInformations entry = new AllianceFactSheetInformations();
			entry.deserialize(reader);
			this.alliances.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.alliances.size());
		for (AllianceFactSheetInformations entry : this.alliances)
		{
			entry.serialize(writer);
		}
	}
}