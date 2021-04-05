package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeStartedMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeStartedWithPodsMessage extends ExchangeStartedMessage {
	public static final int MESSAGE_ID = 6129;
	
	private int firstCharacterId;
	private int firstCharacterCurrentWeight;
	private int firstCharacterMaxWeight;
	private int secondCharacterId;
	private int secondCharacterCurrentWeight;
	private int secondCharacterMaxWeight;
	
	public ExchangeStartedWithPodsMessage() {
	}
	
	public ExchangeStartedWithPodsMessage(byte exchangeType, int firstCharacterId, int firstCharacterCurrentWeight, int firstCharacterMaxWeight, int secondCharacterId, int secondCharacterCurrentWeight, int secondCharacterMaxWeight) {
		super(exchangeType);
		this.firstCharacterId = firstCharacterId;
		this.firstCharacterCurrentWeight = firstCharacterCurrentWeight;
		this.firstCharacterMaxWeight = firstCharacterMaxWeight;
		this.secondCharacterId = secondCharacterId;
		this.secondCharacterCurrentWeight = secondCharacterCurrentWeight;
		this.secondCharacterMaxWeight = secondCharacterMaxWeight;
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
		this.firstCharacterId = reader.readInt();
		this.firstCharacterCurrentWeight = reader.readInt();
		if (firstCharacterCurrentWeight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firstCharacterCurrentWeight = %s, it doesn't respect the following condition : firstCharacterCurrentWeight < 0", firstCharacterCurrentWeight));
		this.firstCharacterMaxWeight = reader.readInt();
		if (firstCharacterMaxWeight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on firstCharacterMaxWeight = %s, it doesn't respect the following condition : firstCharacterMaxWeight < 0", firstCharacterMaxWeight));
		this.secondCharacterId = reader.readInt();
		this.secondCharacterCurrentWeight = reader.readInt();
		if (secondCharacterCurrentWeight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on secondCharacterCurrentWeight = %s, it doesn't respect the following condition : secondCharacterCurrentWeight < 0", secondCharacterCurrentWeight));
		this.secondCharacterMaxWeight = reader.readInt();
		if (secondCharacterMaxWeight < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on secondCharacterMaxWeight = %s, it doesn't respect the following condition : secondCharacterMaxWeight < 0", secondCharacterMaxWeight));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.firstCharacterId);
		writer.writeInt(this.firstCharacterCurrentWeight);
		writer.writeInt(this.firstCharacterMaxWeight);
		writer.writeInt(this.secondCharacterId);
		writer.writeInt(this.secondCharacterCurrentWeight);
		writer.writeInt(this.secondCharacterMaxWeight);
	}
}