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
public class HouseBuyRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5738;
	
	private int proposedPrice;
	
	public HouseBuyRequestMessage() {
	}
	
	public HouseBuyRequestMessage(int proposedPrice) {
		this.proposedPrice = proposedPrice;
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
		this.proposedPrice = reader.readInt();
		if (proposedPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on proposedPrice = %s, it doesn't respect the following condition : proposedPrice < 0", proposedPrice));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.proposedPrice);
	}
}