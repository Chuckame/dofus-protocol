package org.michocko.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.EntityMovementInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameContextMoveMultipleElementsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 254;
	
	private Collection<EntityMovementInformations> movements;
	
	public GameContextMoveMultipleElementsMessage() {
	}
	
	public GameContextMoveMultipleElementsMessage(Collection<EntityMovementInformations> movements) {
		this.movements = movements;
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
		int length = reader.readUShort();
		this.movements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			EntityMovementInformations entry = new EntityMovementInformations();
			entry.deserialize(reader);
			this.movements.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.movements.size());
		for (EntityMovementInformations entry : this.movements)
		{
			entry.serialize(writer);
		}
	}
}