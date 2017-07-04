package org.michocko.dofus2.protocol.messages.game.context.fight.character;

import org.michocko.dofus2.protocol.types.game.context.fight.GameFightFighterInformations;
import org.michocko.dofus2.protocol.messages.game.context.fight.character.GameFightShowFighterMessage;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
	public int getNetworkMessageId() {
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