package org.chuckame.dofus2.protocol.messages.game.achievement;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.protocol.types.game.achievement.Achievement;

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
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.achievement = new Achievement();
		this.achievement.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		this.achievement.serialize(writer);
	}
}