package org.michocko.dofus2.protocol.messages.game.achievement;

import org.michocko.dofus2.protocol.types.game.achievement.Achievement;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AchievementDetailsMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6378;
	
	private Achievement achievement;
	
	public AchievementDetailsMessage() {
	}
	
	public AchievementDetailsMessage(Achievement achievement) {
		this.achievement = achievement;
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
		this.achievement = new Achievement();
		this.achievement.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		this.achievement.serialize(writer);
	}
}