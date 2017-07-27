package org.chuckame.dofus2.protocol.messages.game.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GuildInvitationByNameMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6115;
	
	private String name;
	
	public GuildInvitationByNameMessage() {
	}
	
	public GuildInvitationByNameMessage(String name) {
		this.name = name;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.name = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUTF(this.name);
	}
}