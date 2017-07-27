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
public class HouseBuyRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5738;
	
	private int proposedPrice;
	
	public HouseBuyRequestMessage() {
	}
	
	public HouseBuyRequestMessage(int proposedPrice) {
		this.proposedPrice = proposedPrice;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.proposedPrice = reader.readInt();
		if (proposedPrice < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on proposedPrice = %s, it doesn't respect the following condition : proposedPrice < 0", proposedPrice));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.proposedPrice);
	}
}