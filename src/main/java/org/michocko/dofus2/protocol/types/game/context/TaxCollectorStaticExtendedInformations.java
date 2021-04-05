package org.michocko.dofus2.protocol.types.game.context;

import org.michocko.dofus2.protocol.types.game.context.roleplay.AllianceInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GuildInformations;
import org.michocko.dofus2.protocol.types.game.context.TaxCollectorStaticInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class TaxCollectorStaticExtendedInformations extends TaxCollectorStaticInformations {
	public static final short TYPE_ID = 440;
	
	private AllianceInformations allianceIdentity;
	
	public TaxCollectorStaticExtendedInformations() {
	}
	
	public TaxCollectorStaticExtendedInformations(short firstNameId, short lastNameId, GuildInformations guildIdentity, AllianceInformations allianceIdentity) {
		super(firstNameId, lastNameId, guildIdentity);
		this.allianceIdentity = allianceIdentity;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceIdentity = new AllianceInformations();
		this.allianceIdentity.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.allianceIdentity.serialize(writer);
	}
}