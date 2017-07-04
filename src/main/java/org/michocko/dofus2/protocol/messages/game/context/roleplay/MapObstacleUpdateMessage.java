package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.interactive.MapObstacle;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MapObstacleUpdateMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6051;
	
	private Collection<MapObstacle> obstacles;
	
	public MapObstacleUpdateMessage() {
	}
	
	public MapObstacleUpdateMessage(Collection<MapObstacle> obstacles) {
		this.obstacles = obstacles;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.obstacles = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MapObstacle entry = new MapObstacle();
			entry.deserialize(reader);
			this.obstacles.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.obstacles.size());
		for (MapObstacle entry : this.obstacles)
		{
			entry.serialize(writer);
		}
	}
}