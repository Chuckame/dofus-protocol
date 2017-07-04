package org.michocko.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.house.HouseInformationsForGuild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildHousesInformationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5919;
	
	private Collection<HouseInformationsForGuild> housesInformations;
	
	public GuildHousesInformationMessage() {
	}
	
	public GuildHousesInformationMessage(Collection<HouseInformationsForGuild> housesInformations) {
		this.housesInformations = housesInformations;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.housesInformations = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			HouseInformationsForGuild entry = new HouseInformationsForGuild();
			entry.deserialize(reader);
			this.housesInformations.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.housesInformations.size());
		for (HouseInformationsForGuild entry : this.housesInformations)
		{
			entry.serialize(writer);
		}
	}
}