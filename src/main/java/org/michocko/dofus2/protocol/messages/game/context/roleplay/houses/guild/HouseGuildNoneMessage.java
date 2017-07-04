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
public class HouseGuildNoneMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5701;
	
	private short houseId;
	
	public HouseGuildNoneMessage() {
	}
	
	public HouseGuildNoneMessage(short houseId) {
		this.houseId = houseId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.houseId = reader.readShort();
		if (houseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on houseId = %s, it doesn't respect the following condition : houseId < 0", houseId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.houseId);
	}
}