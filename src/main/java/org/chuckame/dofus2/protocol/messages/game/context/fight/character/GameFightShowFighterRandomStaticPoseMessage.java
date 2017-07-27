package org.chuckame.dofus2.protocol.messages.game.context.fight.character;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.messages.game.context.fight.character.GameFightShowFighterMessage;
import org.chuckame.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class GameFightShowFighterRandomStaticPoseMessage extends GameFightShowFighterMessage {
	public static final int MESSAGE_ID = 6218;
	
	
	public GameFightShowFighterRandomStaticPoseMessage() {
	}
	
	public GameFightShowFighterRandomStaticPoseMessage(GameFightFighterInformations informations) {
		super(informations);
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}