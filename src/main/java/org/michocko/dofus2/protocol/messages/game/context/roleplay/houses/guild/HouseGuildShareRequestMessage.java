package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses.guild;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.enable = reader.readBoolean();
		this.rights = reader.readUInt();
		if (rights < 0 || rights > 4.294967295E9)
			throw new IllegalArgumentException(String.format("Forbidden value on rights = %s, it doesn't respect the following condition : rights < 0 || rights > 4.294967295E9", rights));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.enable);
		writer.writeUInt(this.rights);
	}
}