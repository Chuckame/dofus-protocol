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
public class ExchangeStartOkMulticraftCustomerMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5817;
	
	private byte maxCase;
	private int skillId;
	private byte crafterJobLevel;
	
	public ExchangeStartOkMulticraftCustomerMessage() {
	}
	
	public ExchangeStartOkMulticraftCustomerMessage(byte maxCase, int skillId, byte crafterJobLevel) {
		this.maxCase = maxCase;
		this.skillId = skillId;
		this.crafterJobLevel = crafterJobLevel;
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
		this.maxCase = reader.readSByte();
		if (maxCase < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxCase = %s, it doesn't respect the following condition : maxCase < 0", maxCase));
		this.skillId = reader.readInt();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
		this.crafterJobLevel = reader.readSByte();
		if (crafterJobLevel < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on crafterJobLevel = %s, it doesn't respect the following condition : crafterJobLevel < 0", crafterJobLevel));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.maxCase);
		writer.writeInt(this.skillId);
		writer.writeSByte(this.crafterJobLevel);
	}
}