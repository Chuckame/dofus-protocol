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
public class ExchangeBidHouseGenericItemAddedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5947;
	
	private int objGenericId;
	
	public ExchangeBidHouseGenericItemAddedMessage() {
	}
	
	public ExchangeBidHouseGenericItemAddedMessage(int objGenericId) {
		this.objGenericId = objGenericId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objGenericId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objGenericId);
	}
}