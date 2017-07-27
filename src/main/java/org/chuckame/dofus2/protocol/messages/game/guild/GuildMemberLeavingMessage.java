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
public class GuildMemberLeavingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5923;
	
	private boolean kicked;
	private int memberId;
	
	public GuildMemberLeavingMessage() {
	}
	
	public GuildMemberLeavingMessage(boolean kicked, int memberId) {
		this.kicked = kicked;
		this.memberId = memberId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.kicked = reader.readBoolean();
		this.memberId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.kicked);
		writer.writeInt(this.memberId);
	}
}