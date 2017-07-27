package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.guild.GuildMember;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInformationsMemberUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5597;
	
	private GuildMember member;
	
	public GuildInformationsMemberUpdateMessage() {
	}
	
	public GuildInformationsMemberUpdateMessage(GuildMember member) {
		this.member = member;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.member = new GuildMember();
		this.member.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.member.serialize(writer);
	}
}