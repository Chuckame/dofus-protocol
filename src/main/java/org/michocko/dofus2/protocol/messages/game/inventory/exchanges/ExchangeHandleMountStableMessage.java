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
public class ExchangeHandleMountStableMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5965;
	
	private byte actionType;
	private int rideId;
	
	public ExchangeHandleMountStableMessage() {
	}
	
	public ExchangeHandleMountStableMessage(byte actionType, int rideId) {
		this.actionType = actionType;
		this.rideId = rideId;
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
		this.actionType = reader.readSByte();
		this.rideId = reader.readInt();
		if (rideId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on rideId = %s, it doesn't respect the following condition : rideId < 0", rideId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeSByte(this.actionType);
		writer.writeInt(this.rideId);
	}
}