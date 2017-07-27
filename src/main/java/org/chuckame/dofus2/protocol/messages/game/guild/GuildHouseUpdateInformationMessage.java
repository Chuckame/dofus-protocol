package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.house.HouseInformationsForGuild;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildHouseUpdateInformationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6181;
	
	private HouseInformationsForGuild housesInformations;
	
	public GuildHouseUpdateInformationMessage() {
	}
	
	public GuildHouseUpdateInformationMessage(HouseInformationsForGuild housesInformations) {
		this.housesInformations = housesInformations;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.housesInformations = new HouseInformationsForGuild();
		this.housesInformations.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.housesInformations.serialize(writer);
	}
}