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
public class ExchangeOnHumanVendorRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5772;
	
	private int humanVendorId;
	private int humanVendorCell;
	
	public ExchangeOnHumanVendorRequestMessage() {
	}
	
	public ExchangeOnHumanVendorRequestMessage(int humanVendorId, int humanVendorCell) {
		this.humanVendorId = humanVendorId;
		this.humanVendorCell = humanVendorCell;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.humanVendorId = reader.readInt();
		if (humanVendorId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on humanVendorId = %s, it doesn't respect the following condition : humanVendorId < 0", humanVendorId));
		this.humanVendorCell = reader.readInt();
		if (humanVendorCell < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on humanVendorCell = %s, it doesn't respect the following condition : humanVendorCell < 0", humanVendorCell));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.humanVendorId);
		writer.writeInt(this.humanVendorCell);
	}
}