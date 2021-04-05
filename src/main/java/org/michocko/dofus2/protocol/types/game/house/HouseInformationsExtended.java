package org.michocko.dofus2.protocol.types.game.house;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.GuildInformations;
import org.michocko.dofus2.protocol.types.game.house.HouseInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class HouseInformationsExtended extends HouseInformations {
	public static final short TYPE_ID = 112;
	
	private GuildInformations guildInfo;
	
	public HouseInformationsExtended() {
	}
	
	public HouseInformationsExtended(int houseId, Collection<Integer> doorsOnMap, String ownerName, short modelId, GuildInformations guildInfo) {
		super(houseId, doorsOnMap, ownerName, modelId);
		this.guildInfo = guildInfo;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guildInfo = new GuildInformations();
		this.guildInfo.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.guildInfo.serialize(writer);
	}
}