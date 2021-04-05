package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeRequestMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangePlayerMultiCraftRequestMessage extends ExchangeRequestMessage {
	public static final int MESSAGE_ID = 5784;
	
	private int target;
	private int skillId;
	
	public ExchangePlayerMultiCraftRequestMessage() {
	}
	
	public ExchangePlayerMultiCraftRequestMessage(byte exchangeType, int target, int skillId) {
		super(exchangeType);
		this.target = target;
		this.skillId = skillId;
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
		super.deserialize(reader);
		this.target = reader.readInt();
		if (target < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on target = %s, it doesn't respect the following condition : target < 0", target));
		this.skillId = reader.readInt();
		if (skillId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on skillId = %s, it doesn't respect the following condition : skillId < 0", skillId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.target);
		writer.writeInt(this.skillId);
	}
}