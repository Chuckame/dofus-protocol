package org.michocko.dofus2.protocol.messages.game.basic;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NumericWhoIsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6298;
	
	private int playerId;
	
	public NumericWhoIsRequestMessage() {
	}
	
	public NumericWhoIsRequestMessage(int playerId) {
		this.playerId = playerId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.playerId);
	}
}