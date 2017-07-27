package org.chuckame.dofus2.protocol.messages.game.context.roleplay.fight;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.context.fight.FightCommonInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class GameRolePlayShowChallengeMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 301;
	
	private FightCommonInformations commonsInfos;
	
	public GameRolePlayShowChallengeMessage() {
	}
	
	public GameRolePlayShowChallengeMessage(FightCommonInformations commonsInfos) {
		this.commonsInfos = commonsInfos;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.commonsInfos = new FightCommonInformations();
		this.commonsInfos.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.commonsInfos.serialize(writer);
	}
}