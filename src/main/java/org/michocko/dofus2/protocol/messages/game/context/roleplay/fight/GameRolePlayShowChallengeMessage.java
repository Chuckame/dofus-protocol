package org.michocko.dofus2.protocol.messages.game.context.roleplay.fight;

import org.michocko.dofus2.protocol.types.game.context.fight.FightCommonInformations;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.commonsInfos = new FightCommonInformations();
		this.commonsInfos.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.commonsInfos.serialize(writer);
	}
}