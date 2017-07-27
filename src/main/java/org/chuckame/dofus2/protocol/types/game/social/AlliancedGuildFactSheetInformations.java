package org.chuckame.dofus2.protocol.types.game.social;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicNamedAllianceInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GuildInformations;
import org.chuckame.dofus2.protocol.types.game.guild.GuildEmblem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class AlliancedGuildFactSheetInformations extends GuildInformations {
	public static final short TYPE_ID = 422;
	
	private BasicNamedAllianceInformations allianceInfos;
	
	public AlliancedGuildFactSheetInformations() {
	}
	
	public AlliancedGuildFactSheetInformations(int guildId, String guildName, GuildEmblem guildEmblem, BasicNamedAllianceInformations allianceInfos) {
		super(guildId, guildName, guildEmblem);
		this.allianceInfos = allianceInfos;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.allianceInfos = new BasicNamedAllianceInformations();
		this.allianceInfos.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.allianceInfos.serialize(writer);
	}
}