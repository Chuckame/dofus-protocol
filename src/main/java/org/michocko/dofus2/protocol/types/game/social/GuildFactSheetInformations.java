package org.michocko.dofus2.protocol.types.game.social;

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
public class GuildFactSheetInformations extends GuildInformations {
	public static final short TYPE_ID = 424;
	
	private int leaderId;
	private short guildLevel;
	private short nbMembers;
	
	public GuildFactSheetInformations() {
	}
	
	public GuildFactSheetInformations(int guildId, String guildName, GuildEmblem guildEmblem, int leaderId, short guildLevel, short nbMembers) {
		super(guildId, guildName, guildEmblem);
		this.leaderId = leaderId;
		this.guildLevel = guildLevel;
		this.nbMembers = nbMembers;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.leaderId = reader.readInt();
		if (leaderId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on leaderId = %s, it doesn't respect the following condition : leaderId < 0", leaderId));
		this.guildLevel = reader.readByte();
		if (guildLevel < 0 || guildLevel > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on guildLevel = %s, it doesn't respect the following condition : guildLevel < 0 || guildLevel > 255", guildLevel));
		this.nbMembers = reader.readShort();
		if (nbMembers < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbMembers = %s, it doesn't respect the following condition : nbMembers < 0", nbMembers));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.leaderId);
		writer.writeByte(this.guildLevel);
		writer.writeShort(this.nbMembers);
	}
}