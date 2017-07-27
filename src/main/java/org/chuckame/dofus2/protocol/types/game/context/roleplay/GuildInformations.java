package org.chuckame.dofus2.protocol.types.game.context.roleplay;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;
import org.chuckame.dofus2.protocol.types.game.guild.GuildEmblem;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GuildInformations extends BasicGuildInformations {
	public static final short TYPE_ID = 127;
	
	private GuildEmblem guildEmblem;
	
	public GuildInformations() {
	}
	
	public GuildInformations(int guildId, String guildName, GuildEmblem guildEmblem) {
		super(guildId, guildName);
		this.guildEmblem = guildEmblem;
	}
	
	@Override
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guildEmblem = new GuildEmblem();
		this.guildEmblem.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.guildEmblem.serialize(writer);
	}
}