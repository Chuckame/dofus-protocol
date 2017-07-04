package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseToSellListRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6139;
	
	private short pageIndex;
	
	public HouseToSellListRequestMessage() {
	}
	
	public HouseToSellListRequestMessage(short pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.pageIndex = reader.readShort();
		if (pageIndex < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on pageIndex = %s, it doesn't respect the following condition : pageIndex < 0", pageIndex));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.pageIndex);
	}
}