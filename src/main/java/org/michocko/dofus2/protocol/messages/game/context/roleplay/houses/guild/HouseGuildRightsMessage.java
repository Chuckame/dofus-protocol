package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses.guild;

import org.michocko.dofus2.protocol.types.game.context.roleplay.GuildInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseGuildRightsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5703;
	
	private short houseId;
	private GuildInformations guildInfo;
	private long rights;
	
	public HouseGuildRightsMessage() {
	}
	
	public HouseGuildRightsMessage(short houseId, GuildInformations guildInfo, long rights) {
		this.houseId = houseId;
		this.guildInfo = guildInfo;
		this.rights = rights;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.houseId = reader.readShort();
		if (houseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on houseId = %s, it doesn't respect the following condition : houseId < 0", houseId));
		this.guildInfo = new GuildInformations();
		this.guildInfo.deserialize(reader);
		this.rights = reader.readUInt();
		if (rights < 0 || rights > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on rights = %s, it doesn't respect the following condition : rights < 0 || rights > 4.294967295E9", rights));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.houseId);
		this.guildInfo.serialize(writer);
		writer.writeUInt(this.rights);
	}
}