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
public class GuildPaddockRemovedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5955;
	
	private int paddockId;
	
	public GuildPaddockRemovedMessage() {
	}
	
	public GuildPaddockRemovedMessage(int paddockId) {
		this.paddockId = paddockId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.paddockId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.paddockId);
	}
}