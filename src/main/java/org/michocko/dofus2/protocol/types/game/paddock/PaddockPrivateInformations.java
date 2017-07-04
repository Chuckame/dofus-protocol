package org.michocko.dofus2.protocol.types.game.paddock;

import org.michocko.dofus2.protocol.types.game.context.roleplay.GuildInformations;
import org.michocko.dofus2.protocol.types.game.paddock.PaddockAbandonnedInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class PaddockPrivateInformations extends PaddockAbandonnedInformations {
	public static final short TYPE_ID = 131;
	
	private GuildInformations guildInfo;
	
	public PaddockPrivateInformations() {
	}
	
	public PaddockPrivateInformations(short maxOutdoorMount, short maxItems, int price, boolean locked, int guildId, GuildInformations guildInfo) {
		super(maxOutdoorMount, maxItems, price, locked, guildId);
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