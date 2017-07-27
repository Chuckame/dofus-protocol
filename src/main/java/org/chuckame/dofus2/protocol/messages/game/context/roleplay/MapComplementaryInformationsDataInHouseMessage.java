package org.chuckame.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.MapComplementaryInformationsDataMessage;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightCommonInformations;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.GameRolePlayActorInformations;
import org.chuckame.dofus2.protocol.types.game.house.HouseInformations;
import org.chuckame.dofus2.protocol.types.game.house.HouseInformationsInside;
import org.chuckame.dofus2.protocol.types.game.interactive.InteractiveElement;
import org.chuckame.dofus2.protocol.types.game.interactive.MapObstacle;
import org.chuckame.dofus2.protocol.types.game.interactive.StatedElement;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class MapComplementaryInformationsDataInHouseMessage extends MapComplementaryInformationsDataMessage {
	public static final int MESSAGE_ID = 6130;
	
	private HouseInformationsInside currentHouse;
	
	public MapComplementaryInformationsDataInHouseMessage() {
	}
	
	public MapComplementaryInformationsDataInHouseMessage(short subAreaId, int mapId, Collection<HouseInformations> houses, Collection<GameRolePlayActorInformations> actors, Collection<InteractiveElement> interactiveElements, Collection<StatedElement> statedElements, Collection<MapObstacle> obstacles, Collection<FightCommonInformations> fights, HouseInformationsInside currentHouse) {
		super(subAreaId, mapId, houses, actors, interactiveElements, statedElements, obstacles, fights);
		this.currentHouse = currentHouse;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.currentHouse = new HouseInformationsInside();
		this.currentHouse.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		this.currentHouse.serialize(writer);
	}
}