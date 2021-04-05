package org.michocko.dofus2.protocol.messages.game.guild;

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
public class GuildHouseUpdateInformationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6181;
	
	private HouseInformationsForGuild housesInformations;
	
	public GuildHouseUpdateInformationMessage() {
	}
	
	public GuildHouseUpdateInformationMessage(HouseInformationsForGuild housesInformations) {
		this.housesInformations = housesInformations;
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
		this.housesInformations = new HouseInformationsForGuild();
		this.housesInformations.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.housesInformations.serialize(writer);
	}
}