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
public class ExchangeIsReadyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5509;
	
	private int id;
	private boolean ready;
	
	public ExchangeIsReadyMessage() {
	}
	
	public ExchangeIsReadyMessage(int id, boolean ready) {
		this.id = id;
		this.ready = ready;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readInt();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
		this.ready = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.id);
		writer.writeBoolean(this.ready);
	}
}