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
public class GuildKickRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5887;
	
	private int kickedId;
	
	public GuildKickRequestMessage() {
	}
	
	public GuildKickRequestMessage(int kickedId) {
		this.kickedId = kickedId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.kickedId = reader.readInt();
		if (kickedId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on kickedId = %s, it doesn't respect the following condition : kickedId < 0", kickedId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.kickedId);
	}
}