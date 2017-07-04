package org.michocko.dofus2.protocol.messages.game.alliance;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.social.AllianceVersatileInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceVersatileInfoListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6436;
	
	private Collection<AllianceVersatileInformations> alliances;
	
	public AllianceVersatileInfoListMessage() {
	}
	
	public AllianceVersatileInfoListMessage(Collection<AllianceVersatileInformations> alliances) {
		this.alliances = alliances;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.alliances = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AllianceVersatileInformations entry = new AllianceVersatileInformations();
			entry.deserialize(reader);
			this.alliances.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.alliances.size());
		for (AllianceVersatileInformations entry : this.alliances)
		{
			entry.serialize(writer);
		}
	}
}