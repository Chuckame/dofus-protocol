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
public class ExchangeSetCraftRecipeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6389;
	
	private short objectGID;
	
	public ExchangeSetCraftRecipeMessage() {
	}
	
	public ExchangeSetCraftRecipeMessage(short objectGID) {
		this.objectGID = objectGID;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.objectGID = reader.readShort();
		if (objectGID < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectGID = %s, it doesn't respect the following condition : objectGID < 0", objectGID));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.objectGID);
	}
}