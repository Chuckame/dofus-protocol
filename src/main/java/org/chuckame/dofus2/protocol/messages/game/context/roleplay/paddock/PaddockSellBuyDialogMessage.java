package org.chuckame.dofus2.protocol.messages.game.context.roleplay.paddock;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class PaddockSellBuyDialogMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6018;
	
	private boolean bsell;
	private int ownerId;
	private int price;
	
	public PaddockSellBuyDialogMessage() {
	}
	
	public PaddockSellBuyDialogMessage(boolean bsell, int ownerId, int price) {
		this.bsell = bsell;
		this.ownerId = ownerId;
		this.price = price;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.bsell = reader.readBoolean();
		this.ownerId = reader.readInt();
		if (ownerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on ownerId = %s, it doesn't respect the following condition : ownerId < 0", ownerId));
		this.price = reader.readInt();
		if (price < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on price = %s, it doesn't respect the following condition : price < 0", price));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeBoolean(this.bsell);
		writer.writeInt(this.ownerId);
		writer.writeInt(this.price);
	}
}