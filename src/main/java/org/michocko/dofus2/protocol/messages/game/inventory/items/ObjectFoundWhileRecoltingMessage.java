package org.michocko.dofus2.protocol.messages.game.inventory.items;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class ObjectFoundWhileRecoltingMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6017;
	
	private int genericId;
	private int quantity;
	private int ressourceGenericId;
	
	public ObjectFoundWhileRecoltingMessage() {
	}
	
	public ObjectFoundWhileRecoltingMessage(int genericId, int quantity, int ressourceGenericId) {
		this.genericId = genericId;
		this.quantity = quantity;
		this.ressourceGenericId = ressourceGenericId;
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
		this.genericId = reader.readInt();
		if (genericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on genericId = %s, it doesn't respect the following condition : genericId < 0", genericId));
		this.quantity = reader.readInt();
		if (quantity < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on quantity = %s, it doesn't respect the following condition : quantity < 0", quantity));
		this.ressourceGenericId = reader.readInt();
		if (ressourceGenericId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on ressourceGenericId = %s, it doesn't respect the following condition : ressourceGenericId < 0", ressourceGenericId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeInt(this.genericId);
		writer.writeInt(this.quantity);
		writer.writeInt(this.ressourceGenericId);
	}
}