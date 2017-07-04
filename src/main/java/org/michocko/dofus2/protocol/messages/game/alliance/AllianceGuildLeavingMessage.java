package org.michocko.dofus2.protocol.messages.game.alliance;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AllianceGuildLeavingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6399;
	
	private boolean kicked;
	private int guildId;
	
	public AllianceGuildLeavingMessage() {
	}
	
	public AllianceGuildLeavingMessage(boolean kicked, int guildId) {
		this.kicked = kicked;
		this.guildId = guildId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.kicked = reader.readBoolean();
		this.guildId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.kicked);
		writer.writeInt(this.guildId);
	}
}