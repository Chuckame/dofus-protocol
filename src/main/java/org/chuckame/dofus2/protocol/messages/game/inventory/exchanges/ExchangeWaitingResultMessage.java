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
public class ExchangeWaitingResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5786;
	
	private boolean bwait;
	
	public ExchangeWaitingResultMessage() {
	}
	
	public ExchangeWaitingResultMessage(boolean bwait) {
		this.bwait = bwait;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.bwait = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.bwait);
	}
}