package org.chuckame.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.messages.game.guild.GuildFactsMessage;
import org.chuckame.dofus2.protocol.types.game.character.CharacterMinimalInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicNamedAllianceInformations;
import org.chuckame.dofus2.protocol.types.game.social.GuildFactSheetInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GuildInAllianceFactsMessage extends GuildFactsMessage {
	public static final int MESSAGE_ID = 6422;
	
	private BasicNamedAllianceInformations allianceInfos;
	
	public GuildInAllianceFactsMessage() {
	}
	
	public GuildInAllianceFactsMessage(GuildFactSheetInformations infos, int creationDate, short nbTaxCollectors, boolean enabled, Collection<CharacterMinimalInformations> members, BasicNamedAllianceInformations allianceInfos) {
		super(infos, creationDate, nbTaxCollectors, enabled, members);
		this.allianceInfos = allianceInfos;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
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