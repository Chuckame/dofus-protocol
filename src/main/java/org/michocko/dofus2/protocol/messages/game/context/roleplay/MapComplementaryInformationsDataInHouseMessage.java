package org.michocko.dofus2.protocol.messages.game.context.roleplay;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.house.HouseInformationsInside;
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
	public int getNetworkMessageId() {
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