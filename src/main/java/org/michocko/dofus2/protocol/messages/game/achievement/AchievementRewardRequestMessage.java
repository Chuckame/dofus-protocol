package org.michocko.dofus2.protocol.messages.game.achievement;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AchievementRewardRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6377;
	
	private short achievementId;
	
	public AchievementRewardRequestMessage() {
	}
	
	public AchievementRewardRequestMessage(short achievementId) {
		this.achievementId = achievementId;
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
		this.achievementId = reader.readShort();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.achievementId);
	}
}