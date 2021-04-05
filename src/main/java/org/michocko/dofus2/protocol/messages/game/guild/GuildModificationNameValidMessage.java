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
public class GuildModificationNameValidMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6327;
	
	private String guildName;
	
	public GuildModificationNameValidMessage() {
	}
	
	public GuildModificationNameValidMessage(String guildName) {
		this.guildName = guildName;
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
		this.guildName = reader.readUTF();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.guildName);
	}
}