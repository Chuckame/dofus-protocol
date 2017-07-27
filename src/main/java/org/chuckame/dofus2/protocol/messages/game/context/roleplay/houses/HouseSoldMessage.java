package org.chuckame.dofus2.protocol.messages.game.context.roleplay.houses;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseSoldMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5737;
	
	private int houseId;
	private int realPrice;
	private String buyerName;
	
	public HouseSoldMessage() {
	}
	
	public HouseSoldMessage(int houseId, int realPrice, String buyerName) {
		this.houseId = houseId;
		this.realPrice = realPrice;
		this.buyerName = buyerName;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.houseId = reader.readInt();
		if (houseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on houseId = %s, it doesn't respect the following condition : houseId < 0", houseId));
		this.realPrice = reader.readInt();
		if (realPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on realPrice = %s, it doesn't respect the following condition : realPrice < 0", realPrice));
		this.buyerName = reader.readUTF();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.houseId);
		writer.writeInt(this.realPrice);
		writer.writeUTF(this.buyerName);
	}
}