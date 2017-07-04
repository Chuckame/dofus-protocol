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
public class ExchangeBidHouseBuyMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5804;
	
	private int uid;
	private int qty;
	private int price;
	
	public ExchangeBidHouseBuyMessage() {
	}
	
	public ExchangeBidHouseBuyMessage(int uid, int qty, int price) {
		this.uid = uid;
		this.qty = qty;
		this.price = price;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.uid = reader.readInt();
		if (uid < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on uid = %s, it doesn't respect the following condition : uid < 0", uid));
		this.qty = reader.readInt();
		if (qty < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on qty = %s, it doesn't respect the following condition : qty < 0", qty));
		this.price = reader.readInt();
		if (price < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0", price));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.uid);
		writer.writeInt(this.qty);
		writer.writeInt(this.price);
	}
}