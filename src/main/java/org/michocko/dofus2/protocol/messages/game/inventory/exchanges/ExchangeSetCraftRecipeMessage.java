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
public class ExchangeSetCraftRecipeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6389;
	
	private short objectGID;
	
	public ExchangeSetCraftRecipeMessage() {
	}
	
	public ExchangeSetCraftRecipeMessage(short objectGID) {
		this.objectGID = objectGID;
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
		this.objectGID = reader.readShort();
		if (objectGID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGID = %s, it doesn't respect the following condition : objectGID < 0", objectGID));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.objectGID);
	}
}