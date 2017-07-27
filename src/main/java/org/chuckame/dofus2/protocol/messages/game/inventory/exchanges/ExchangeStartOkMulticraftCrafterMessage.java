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
public class ExchangeStartOkMulticraftCrafterMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5818;
	
	private byte maxCase;
	private int skillId;
	
	public ExchangeStartOkMulticraftCrafterMessage() {
	}
	
	public ExchangeStartOkMulticraftCrafterMessage(byte maxCase, int skillId) {
		this.maxCase = maxCase;
		this.skillId = skillId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.maxCase = reader.readSByte();
		if (maxCase < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxCase = %s, it doesn't respect the following condition : maxCase < 0", maxCase));
		this.skillId = reader.readInt();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.maxCase);
		writer.writeInt(this.skillId);
	}
}