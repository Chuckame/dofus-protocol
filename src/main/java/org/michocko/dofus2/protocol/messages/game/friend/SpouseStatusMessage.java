package org.michocko.dofus2.protocol.messages.game.friend;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class SpouseStatusMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6265;
	
	private boolean hasSpouse;
	
	public SpouseStatusMessage() {
	}
	
	public SpouseStatusMessage(boolean hasSpouse) {
		this.hasSpouse = hasSpouse;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.hasSpouse = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.hasSpouse);
	}
}