package org.michocko.dofus2.protocol.types.game.context.roleplay;

import org.michocko.dofus2.protocol.types.game.guild.GuildEmblem;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GuildInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GuildInAllianceInformations extends GuildInformations {
	public static final short TYPE_ID = 420;
	
	private int guildLevel;
	private int nbMembers;
	private boolean enabled;
	
	public GuildInAllianceInformations() {
	}
	
	public GuildInAllianceInformations(int guildId, String guildName, GuildEmblem guildEmblem, int guildLevel, int nbMembers, boolean enabled) {
		super(guildId, guildName, guildEmblem);
		this.guildLevel = guildLevel;
		this.nbMembers = nbMembers;
		this.enabled = enabled;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.guildLevel = reader.readUShort();
		if (guildLevel < 0 || guildLevel > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on guildLevel = %s, it doesn't respect the following condition : guildLevel < 0 || guildLevel > 65535", guildLevel));
		this.nbMembers = reader.readUShort();
		if (nbMembers < 0 || nbMembers > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on nbMembers = %s, it doesn't respect the following condition : nbMembers < 0 || nbMembers > 65535", nbMembers));
		this.enabled = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUShort(this.guildLevel);
		writer.writeUShort(this.nbMembers);
		writer.writeBoolean(this.enabled);
	}
}