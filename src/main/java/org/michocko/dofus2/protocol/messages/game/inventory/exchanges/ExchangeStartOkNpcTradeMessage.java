package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ExchangeStartOkNpcTradeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5785;
	
	private int npcId;
	
	public ExchangeStartOkNpcTradeMessage() {
	}
	
	public ExchangeStartOkNpcTradeMessage(int npcId) {
		this.npcId = npcId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.npcId = reader.readInt();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.npcId);
	}
}