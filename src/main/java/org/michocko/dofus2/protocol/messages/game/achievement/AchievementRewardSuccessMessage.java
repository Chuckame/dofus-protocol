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
public class AchievementRewardSuccessMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6376;
	
	private short achievementId;
	
	public AchievementRewardSuccessMessage() {
	}
	
	public AchievementRewardSuccessMessage(short achievementId) {
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