package org.chuckame.dofus2.protocol.messages.game.context;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameMapMovementRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 950;
	
	private Collection<Short> keyMovements;
	private int mapId;
	
	public GameMapMovementRequestMessage() {
	}
	
	public GameMapMovementRequestMessage(Collection<Short> keyMovements, int mapId) {
		this.keyMovements = keyMovements;
		this.mapId = mapId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.keyMovements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.keyMovements.add(entry);
		}
		this.mapId = reader.readInt();
		if (mapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mapId = %s, it doesn't respect the following condition : mapId < 0", mapId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.keyMovements.size());
		for (short entry : this.keyMovements)
		{
			writer.writeShort(entry);
		}
		writer.writeInt(this.mapId);
	}
}