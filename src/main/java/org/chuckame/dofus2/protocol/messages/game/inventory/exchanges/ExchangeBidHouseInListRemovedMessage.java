package org.chuckame.dofus2.protocol.messages.game.inventory.exchanges;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeBidHouseInListRemovedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5950;
	
	private int itemUID;
	
	public ExchangeBidHouseInListRemovedMessage() {
	}
	
	public ExchangeBidHouseInListRemovedMessage(int itemUID) {
		this.itemUID = itemUID;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.itemUID = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.itemUID);
	}
}