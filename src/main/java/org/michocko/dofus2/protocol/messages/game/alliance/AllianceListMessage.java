package org.michocko.dofus2.protocol.messages.game.alliance;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.social.AllianceFactSheetInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		int length = reader.readUShort();
		this.alliances = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AllianceFactSheetInformations entry = new AllianceFactSheetInformations();
			entry.deserialize(reader);
			this.alliances.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.alliances.size());
		for (AllianceFactSheetInformations entry : this.alliances)
		{
			entry.serialize(writer);
		}
	}
}