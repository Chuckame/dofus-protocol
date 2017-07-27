package org.chuckame.dofus2.protocol.messages.game.context.roleplay.houses;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.house.AccountHouseInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AccountHouseMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6315;
	
	private Collection<AccountHouseInformations> houses;
	
	public AccountHouseMessage() {
	}
	
	public AccountHouseMessage(Collection<AccountHouseInformations> houses) {
		this.houses = houses;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.houses = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AccountHouseInformations entry = new AccountHouseInformations();
			entry.deserialize(reader);
			this.houses.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.houses.size());
		for (AccountHouseInformations entry : this.houses)
		{
			entry.serialize(writer);
		}
	}
}