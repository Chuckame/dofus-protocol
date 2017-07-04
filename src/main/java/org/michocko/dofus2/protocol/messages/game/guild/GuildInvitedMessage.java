package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.protocol.types.game.context.roleplay.BasicGuildInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInvitedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5552;
	
	private int recruterId;
	private String recruterName;
	private BasicGuildInformations guildInfo;
	
	public GuildInvitedMessage() {
	}
	
	public GuildInvitedMessage(int recruterId, String recruterName, BasicGuildInformations guildInfo) {
		this.recruterId = recruterId;
		this.recruterName = recruterName;
		this.guildInfo = guildInfo;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.recruterId = reader.readInt();
		if (recruterId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on recruterId = %s, it doesn't respect the following condition : recruterId < 0", recruterId));
		this.recruterName = reader.readUTF();
		this.guildInfo = new BasicGuildInformations();
		this.guildInfo.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.recruterId);
		writer.writeUTF(this.recruterName);
		this.guildInfo.serialize(writer);
	}
}