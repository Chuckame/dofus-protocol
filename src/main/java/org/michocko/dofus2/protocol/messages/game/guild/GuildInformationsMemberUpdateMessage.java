package org.michocko.dofus2.protocol.messages.game.guild;

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
public class GuildInformationsMemberUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5597;
	
	private GuildMember member;
	
	public GuildInformationsMemberUpdateMessage() {
	}
	
	public GuildInformationsMemberUpdateMessage(GuildMember member) {
		this.member = member;
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
		this.member = new GuildMember();
		this.member.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.member.serialize(writer);
	}
}