package org.michocko.dofus2.protocol.messages.game.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildMemberOnlineStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6061;
	
	private int memberId;
	private boolean online;
	
	public GuildMemberOnlineStatusMessage() {
	}
	
	public GuildMemberOnlineStatusMessage(int memberId, boolean online) {
		this.memberId = memberId;
		this.online = online;
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
		this.memberId = reader.readInt();
		if (memberId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on memberId = %s, it doesn't respect the following condition : memberId < 0", memberId));
		this.online = reader.readBoolean();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.memberId);
		writer.writeBoolean(this.online);
	}
}