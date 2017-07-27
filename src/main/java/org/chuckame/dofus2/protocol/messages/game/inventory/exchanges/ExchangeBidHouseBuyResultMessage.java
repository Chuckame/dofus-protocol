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
public class ExchangeBidHouseBuyResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6272;
	
	private int uid;
	private boolean bought;
	
	public ExchangeBidHouseBuyResultMessage() {
	}
	
	public ExchangeBidHouseBuyResultMessage(int uid, boolean bought) {
		this.uid = uid;
		this.bought = bought;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readInt();
		if (uid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on uid = %s, it doesn't respect the following condition : uid < 0", uid));
		this.bought = reader.readBoolean();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.uid);
		writer.writeBoolean(this.bought);
	}
}