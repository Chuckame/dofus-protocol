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
public class ExchangeOkMultiCraftMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5768;
	
	private int initiatorId;
	private int otherId;
	private byte role;
	
	public ExchangeOkMultiCraftMessage() {
	}
	
	public ExchangeOkMultiCraftMessage(int initiatorId, int otherId, byte role) {
		this.initiatorId = initiatorId;
		this.otherId = otherId;
		this.role = role;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.initiatorId = reader.readInt();
		if (initiatorId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on initiatorId = %s, it doesn't respect the following condition : initiatorId < 0", initiatorId));
		this.otherId = reader.readInt();
		if (otherId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on otherId = %s, it doesn't respect the following condition : otherId < 0", otherId));
		this.role = reader.readSByte();
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.initiatorId);
		writer.writeInt(this.otherId);
		writer.writeSByte(this.role);
	}
}