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
public class ExchangeBidHouseGenericItemRemovedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5948;
	
	private int objGenericId;
	
	public ExchangeBidHouseGenericItemRemovedMessage() {
	}
	
	public ExchangeBidHouseGenericItemRemovedMessage(int objGenericId) {
		this.objGenericId = objGenericId;
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
		this.objGenericId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.objGenericId);
	}
}