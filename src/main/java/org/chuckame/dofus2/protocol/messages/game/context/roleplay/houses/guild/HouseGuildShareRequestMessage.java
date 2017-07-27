package org.chuckame.dofus2.protocol.messages.game.context.roleplay.houses.guild;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseGuildShareRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5704;
	
	private boolean enable;
	private long rights;
	
	public HouseGuildShareRequestMessage() {
	}
	
	public HouseGuildShareRequestMessage(boolean enable, long rights) {
		this.enable = enable;
		this.rights = rights;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.enable = reader.readBoolean();
		this.rights = reader.readUInt();
		if (rights < 0 || rights > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on rights = %s, it doesn't respect the following condition : rights < 0 || rights > 4.294967295E9", rights));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enable);
		writer.writeUInt(this.rights);
	}
}