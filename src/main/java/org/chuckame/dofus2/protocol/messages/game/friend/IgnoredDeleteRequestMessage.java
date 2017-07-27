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
public class IgnoredDeleteRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5680;
	
	private int accountId;
	private boolean session;
	
	public IgnoredDeleteRequestMessage() {
	}
	
	public IgnoredDeleteRequestMessage(int accountId, boolean session) {
		this.accountId = accountId;
		this.session = session;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.session = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.accountId);
		writer.writeBoolean(this.session);
	}
}