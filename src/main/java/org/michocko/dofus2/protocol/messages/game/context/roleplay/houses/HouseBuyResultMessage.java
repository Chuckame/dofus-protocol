package org.michocko.dofus2.protocol.messages.game.context.roleplay.houses;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class HouseBuyResultMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5735;
	
	private int houseId;
	private boolean bought;
	private int realPrice;
	
	public HouseBuyResultMessage() {
	}
	
	public HouseBuyResultMessage(int houseId, boolean bought, int realPrice) {
		this.houseId = houseId;
		this.bought = bought;
		this.realPrice = realPrice;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.houseId = reader.readInt();
		if (houseId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on houseId = %s, it doesn't respect the following condition : houseId < 0", houseId));
		this.bought = reader.readBoolean();
		this.realPrice = reader.readInt();
		if (realPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on realPrice = %s, it doesn't respect the following condition : realPrice < 0", realPrice));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.houseId);
		writer.writeBoolean(this.bought);
		writer.writeInt(this.realPrice);
	}
}