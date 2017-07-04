package org.michocko.dofus2.protocol.messages.game.guild;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.guild.GuildMember;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInformationsMembersMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5558;
	
	private Collection<GuildMember> members;
	
	public GuildInformationsMembersMessage() {
	}
	
	public GuildInformationsMembersMessage(Collection<GuildMember> members) {
		this.members = members;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.members = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GuildMember entry = new GuildMember();
			entry.deserialize(reader);
			this.members.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.members.size());
		for (GuildMember entry : this.members)
		{
			entry.serialize(writer);
		}
	}
}