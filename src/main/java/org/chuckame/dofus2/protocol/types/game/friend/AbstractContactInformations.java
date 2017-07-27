package org.chuckame.dofus2.protocol.types.game.friend;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class AbstractContactInformations implements INetworkType {
	public static final short TYPE_ID = 380;
	
	private int accountId;
	private String accountName;
	
	public AbstractContactInformations() {
	}
	
	public AbstractContactInformations(int accountId, String accountName) {
		this.accountId = accountId;
		this.accountName = accountName;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.accountId = reader.readInt();
		if (accountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on accountId = %s, it doesn't respect the following condition : accountId < 0", accountId));
		this.accountName = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.accountId);
		writer.writeUTF(this.accountName);
	}
}