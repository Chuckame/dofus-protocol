package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.guild.GuildJoinedMessage;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GuildInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GuildMembershipMessage extends GuildJoinedMessage {
	public static final int MESSAGE_ID = 5835;
	
	
	public GuildMembershipMessage() {
	}
	
	public GuildMembershipMessage(GuildInformations guildInfo, long memberRights, boolean enabled) {
		super(guildInfo, memberRights, enabled);
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}