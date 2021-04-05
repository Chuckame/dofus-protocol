package org.michocko.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameMapMovementMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 951;
	
	private Collection<Short> keyMovements;
	private int actorId;
	
	public GameMapMovementMessage() {
	}
	
	public GameMapMovementMessage(Collection<Short> keyMovements, int actorId) {
		this.keyMovements = keyMovements;
		this.actorId = actorId;
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
		this.keyMovements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.keyMovements.add(entry);
		}
		this.actorId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.keyMovements.size());
		for (short entry : this.keyMovements)
		{
			writer.writeShort(entry);
		}
		writer.writeInt(this.actorId);
	}
}