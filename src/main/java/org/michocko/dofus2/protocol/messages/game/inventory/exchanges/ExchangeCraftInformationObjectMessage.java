package org.michocko.dofus2.protocol.messages.game.inventory.exchanges;

import org.michocko.dofus2.protocol.messages.game.inventory.exchanges.ExchangeCraftResultWithObjectIdMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class ExchangeCraftInformationObjectMessage extends ExchangeCraftResultWithObjectIdMessage {
	public static final int MESSAGE_ID = 5794;
	
	private int playerId;
	
	public ExchangeCraftInformationObjectMessage() {
	}
	
	public ExchangeCraftInformationObjectMessage(byte craftResult, int objectGenericId, int playerId) {
		super(craftResult, objectGenericId);
		this.playerId = playerId;
	}
	
	@Override
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.playerId);
	}
}