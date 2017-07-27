package org.chuckame.dofus2.protocol.types.game.social;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class GuildVersatileInformations implements INetworkType {
	public static final short TYPE_ID = 435;
	
	private int guildId;
	private int leaderId;
	private int guildLevel;
	private int nbMembers;
	
	public GuildVersatileInformations() {
	}
	
	public GuildVersatileInformations(int guildId, int leaderId, int guildLevel, int nbMembers) {
		this.guildId = guildId;
		this.leaderId = leaderId;
		this.guildLevel = guildLevel;
		this.nbMembers = nbMembers;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.guildId = reader.readInt();
		if (guildId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on guildId = %s, it doesn't respect the following condition : guildId < 0", guildId));
		this.leaderId = reader.readInt();
		if (leaderId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on leaderId = %s, it doesn't respect the following condition : leaderId < 0", leaderId));
		this.guildLevel = reader.readUShort();
		if (guildLevel < 0 || guildLevel > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on guildLevel = %s, it doesn't respect the following condition : guildLevel < 0 || guildLevel > 65535", guildLevel));
		this.nbMembers = reader.readUShort();
		if (nbMembers < 0 || nbMembers > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on nbMembers = %s, it doesn't respect the following condition : nbMembers < 0 || nbMembers > 65535", nbMembers));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.guildId);
		writer.writeInt(this.leaderId);
		writer.writeUShort(this.guildLevel);
		writer.writeUShort(this.nbMembers);
	}
}