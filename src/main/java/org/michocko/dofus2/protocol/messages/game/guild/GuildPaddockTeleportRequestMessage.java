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
public class GuildPaddockTeleportRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5957;
	
	private int paddockId;
	
	public GuildPaddockTeleportRequestMessage() {
	}
	
	public GuildPaddockTeleportRequestMessage(int paddockId) {
		this.paddockId = paddockId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.paddockId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.paddockId);
	}
}