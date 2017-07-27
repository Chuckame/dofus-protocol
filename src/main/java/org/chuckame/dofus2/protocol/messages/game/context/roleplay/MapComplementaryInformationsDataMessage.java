package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightCommonInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.chuckame.dofus2.protocol.types.game.house.HouseInformations;
import org.chuckame.dofus2.protocol.types.game.interactive.InteractiveElement;
import org.chuckame.dofus2.protocol.types.game.interactive.MapObstacle;
import org.chuckame.dofus2.protocol.types.game.interactive.StatedElement;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class MapComplementaryInformationsDataMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 226;
	
	private short subAreaId;
	private int mapId;
	private Collection<HouseInformations> houses;
	private Collection<GameRolePlayActorInformations> actors;
	private Collection<InteractiveElement> interactiveElements;
	private Collection<StatedElement> statedElements;
	private Collection<MapObstacle> obstacles;
	private Collection<FightCommonInformations> fights;
	
	public MapComplementaryInformationsDataMessage() {
	}
	
	public MapComplementaryInformationsDataMessage(short subAreaId, int mapId, Collection<HouseInformations> houses, Collection<GameRolePlayActorInformations> actors, Collection<InteractiveElement> interactiveElements, Collection<StatedElement> statedElements, Collection<MapObstacle> obstacles, Collection<FightCommonInformations> fights) {
		this.subAreaId = subAreaId;
		this.mapId = mapId;
		this.houses = houses;
		this.actors = actors;
		this.interactiveElements = interactiveElements;
		this.statedElements = statedElements;
		this.obstacles = obstacles;
		this.fights = fights;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.subAreaId = reader.readShort();
		if (subAreaId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on subAreaId = %s, it doesn't respect the following condition : subAreaId < 0", subAreaId));
		this.mapId = reader.readInt();
		if (mapId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on mapId = %s, it doesn't respect the following condition : mapId < 0", mapId));
		int length = reader.readUShort();
		this.houses = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			HouseInformations entry = ProtocolTypeManager.getInstance().<HouseInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.houses.add(entry);
		}
		length = reader.readUShort();
		this.actors = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			GameRolePlayActorInformations entry = ProtocolTypeManager.getInstance().<GameRolePlayActorInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.actors.add(entry);
		}
		length = reader.readUShort();
		this.interactiveElements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			InteractiveElement entry = ProtocolTypeManager.getInstance().<InteractiveElement>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.interactiveElements.add(entry);
		}
		length = reader.readUShort();
		this.statedElements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			StatedElement entry = new StatedElement();
			entry.deserialize(reader);
			this.statedElements.add(entry);
		}
		length = reader.readUShort();
		this.obstacles = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			MapObstacle entry = new MapObstacle();
			entry.deserialize(reader);
			this.obstacles.add(entry);
		}
		length = reader.readUShort();
		this.fights = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			FightCommonInformations entry = new FightCommonInformations();
			entry.deserialize(reader);
			this.fights.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.subAreaId);
		writer.writeInt(this.mapId);
		writer.writeUShort(this.houses.size());
		for (HouseInformations entry : this.houses)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.actors.size());
		for (GameRolePlayActorInformations entry : this.actors)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.interactiveElements.size());
		for (InteractiveElement entry : this.interactiveElements)
		{
			writer.writeShort(entry.getProtocolTypeId());
			entry.serialize(writer);
		}
		writer.writeUShort(this.statedElements.size());
		for (StatedElement entry : this.statedElements)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.obstacles.size());
		for (MapObstacle entry : this.obstacles)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.fights.size());
		for (FightCommonInformations entry : this.fights)
		{
			entry.serialize(writer);
		}
	}
}