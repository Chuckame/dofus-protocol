package org.chuckame.dofus2.protocol.messages.game.friend;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class FriendDeleteRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5603;
	
	private int accountId;
	
	public FriendDeleteRequestMessage() {
	}
	
	public FriendDeleteRequestMessage(int accountId) {
		this.accountId = accountId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.accountId);
	}
}