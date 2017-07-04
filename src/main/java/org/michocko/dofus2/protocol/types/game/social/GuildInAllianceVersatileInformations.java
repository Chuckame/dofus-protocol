package org.michocko.dofus2.protocol.types.game.social;

import org.michocko.dofus2.protocol.types.game.social.GuildVersatileInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GuildInAllianceVersatileInformations extends GuildVersatileInformations {
	public static final short TYPE_ID = 437;
	
	private int allianceId;
	
	public GuildInAllianceVersatileInformations() {
	}
	
	public GuildInAllianceVersatileInformations(int guildId, int leaderId, int guildLevel, int nbMembers, int allianceId) {
		super(guildId, leaderId, guildLevel, nbMembers);
		this.allianceId = allianceId;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceId = reader.readInt();
		if (allianceId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on allianceId = %s, it doesn't respect the following condition : allianceId < 0", allianceId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.allianceId);
	}
}