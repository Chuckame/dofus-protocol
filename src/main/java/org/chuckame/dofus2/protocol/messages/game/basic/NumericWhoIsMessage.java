package org.chuckame.dofus2.protocol.messages.game.basic;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NumericWhoIsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6297;
	
	private int playerId;
	private int accountId;
	
	public NumericWhoIsMessage() {
	}
	
	public NumericWhoIsMessage(int playerId, int accountId) {
		this.playerId = playerId;
		this.accountId = accountId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.playerId);
		writer.writeInt(this.accountId);
	}
}