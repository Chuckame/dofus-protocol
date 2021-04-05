package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.house.HouseInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.michocko.dofus2.protocol.types.game.interactive.InteractiveElement;
import org.michocko.dofus2.protocol.types.game.interactive.StatedElement;
import org.michocko.dofus2.protocol.types.game.interactive.MapObstacle;
import org.michocko.dofus2.protocol.types.game.context.fight.FightCommonInformations;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.MapComplementaryInformationsDataMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class MapComplementaryInformationsWithCoordsMessage extends MapComplementaryInformationsDataMessage {
	public static final int MESSAGE_ID = 6268;
	
	private short worldX;
	private short worldY;
	
	public MapComplementaryInformationsWithCoordsMessage() {
	}
	
	public MapComplementaryInformationsWithCoordsMessage(short subAreaId, int mapId, Collection<HouseInformations> houses, Collection<GameRolePlayActorInformations> actors, Collection<InteractiveElement> interactiveElements, Collection<StatedElement> statedElements, Collection<MapObstacle> obstacles, Collection<FightCommonInformations> fights, short worldX, short worldY) {
		super(subAreaId, mapId, houses, actors, interactiveElements, statedElements, obstacles, fights);
		this.worldX = worldX;
		this.worldY = worldY;
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
		super.deserialize(reader);
		this.worldX = reader.readShort();
		if (worldX < -255 || worldX > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldX = %s, it doesn't respect the following condition : worldX < -255 || worldX > 255", worldX));
		this.worldY = reader.readShort();
		if (worldY < -255 || worldY > 255)
			throw new IllegalArgumentException(String.format("Forbidden value on worldY = %s, it doesn't respect the following condition : worldY < -255 || worldY > 255", worldY));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.worldX);
		writer.writeShort(this.worldY);
	}
}