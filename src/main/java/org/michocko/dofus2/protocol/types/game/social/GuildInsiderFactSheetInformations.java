package org.michocko.dofus2.protocol.types.game.social;

import org.michocko.dofus2.protocol.types.game.guild.GuildEmblem;
import org.michocko.dofus2.protocol.types.game.social.GuildFactSheetInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class GuildInsiderFactSheetInformations extends GuildFactSheetInformations {
	public static final short TYPE_ID = 423;
	
	private String leaderName;
	private short nbConnectedMembers;
	private byte nbTaxCollectors;
	private int lastActivity;
	private boolean enabled;
	
	public GuildInsiderFactSheetInformations() {
	}
	
	public GuildInsiderFactSheetInformations(int guildId, String guildName, GuildEmblem guildEmblem, int leaderId, short guildLevel, short nbMembers, String leaderName, short nbConnectedMembers, byte nbTaxCollectors, int lastActivity, boolean enabled) {
		super(guildId, guildName, guildEmblem, leaderId, guildLevel, nbMembers);
		this.leaderName = leaderName;
		this.nbConnectedMembers = nbConnectedMembers;
		this.nbTaxCollectors = nbTaxCollectors;
		this.lastActivity = lastActivity;
		this.enabled = enabled;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.leaderName = reader.readUTF();
		this.nbConnectedMembers = reader.readShort();
		if (nbConnectedMembers < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbConnectedMembers = %s, it doesn't respect the following condition : nbConnectedMembers < 0", nbConnectedMembers));
		this.nbTaxCollectors = reader.readSByte();
		if (nbTaxCollectors < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on nbTaxCollectors = %s, it doesn't respect the following condition : nbTaxCollectors < 0", nbTaxCollectors));
		this.lastActivity = reader.readInt();
		if (lastActivity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on lastActivity = %s, it doesn't respect the following condition : lastActivity < 0", lastActivity));
		this.enabled = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.leaderName);
		writer.writeShort(this.nbConnectedMembers);
		writer.writeSByte(this.nbTaxCollectors);
		writer.writeInt(this.lastActivity);
		writer.writeBoolean(this.enabled);
	}
}