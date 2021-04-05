package org.michocko.dofus2.protocol.messages.game.guild;

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
public class GuildJoinedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5564;
	
	private GuildInformations guildInfo;
	private long memberRights;
	private boolean enabled;
	
	public GuildJoinedMessage() {
	}
	
	public GuildJoinedMessage(GuildInformations guildInfo, long memberRights, boolean enabled) {
		this.guildInfo = guildInfo;
		this.memberRights = memberRights;
		this.enabled = enabled;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.guildInfo = new GuildInformations();
		this.guildInfo.deserialize(reader);
		this.memberRights = reader.readUInt();
		if (memberRights < 0 || memberRights > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on memberRights = %s, it doesn't respect the following condition : memberRights < 0 || memberRights > 4.294967295E9", memberRights));
		this.enabled = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.guildInfo.serialize(writer);
		writer.writeUInt(this.memberRights);
		writer.writeBoolean(this.enabled);
	}
}