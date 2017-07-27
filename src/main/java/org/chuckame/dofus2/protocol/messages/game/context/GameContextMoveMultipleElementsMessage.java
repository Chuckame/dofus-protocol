package org.chuckame.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.EntityMovementInformations;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
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
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.movements.size());
		for (EntityMovementInformations entry : this.movements)
		{
			entry.serialize(writer);
		}
	}
}