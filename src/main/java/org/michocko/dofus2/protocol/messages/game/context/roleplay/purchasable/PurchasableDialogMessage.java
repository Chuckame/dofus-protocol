package org.michocko.dofus2.protocol.messages.game.context.roleplay.purchasable;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PurchasableDialogMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5739;
	
	private boolean buyOrSell;
	private int purchasableId;
	private int price;
	
	public PurchasableDialogMessage() {
	}
	
	public PurchasableDialogMessage(boolean buyOrSell, int purchasableId, int price) {
		this.buyOrSell = buyOrSell;
		this.purchasableId = purchasableId;
		this.price = price;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.buyOrSell = reader.readBoolean();
		this.purchasableId = reader.readInt();
		if (purchasableId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on purchasableId = %s, it doesn't respect the following condition : purchasableId < 0", purchasableId));
		this.price = reader.readInt();
		if (price < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0", price));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.buyOrSell);
		writer.writeInt(this.purchasableId);
		writer.writeInt(this.price);
	}
}