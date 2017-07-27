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
public class ExchangeItemObjectAddAsPaymentMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5766;
	
	private byte paymentType;
	private boolean bAdd;
	private int objectToMoveId;
	private int quantity;
	
	public ExchangeItemObjectAddAsPaymentMessage() {
	}
	
	public ExchangeItemObjectAddAsPaymentMessage(byte paymentType, boolean bAdd, int objectToMoveId, int quantity) {
		this.paymentType = paymentType;
		this.bAdd = bAdd;
		this.objectToMoveId = objectToMoveId;
		this.quantity = quantity;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.paymentType = reader.readSByte();
		this.bAdd = reader.readBoolean();
		this.objectToMoveId = reader.readInt();
		if (objectToMoveId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectToMoveId = %s, it doesn't respect the following condition : objectToMoveId < 0", objectToMoveId));
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.paymentType);
		writer.writeBoolean(this.bAdd);
		writer.writeInt(this.objectToMoveId);
		writer.writeInt(this.quantity);
	}
}