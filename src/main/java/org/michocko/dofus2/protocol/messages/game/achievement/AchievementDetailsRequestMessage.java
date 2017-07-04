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
public class AchievementDetailsRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6380;
	
	private short achievementId;
	
	public AchievementDetailsRequestMessage() {
	}
	
	public AchievementDetailsRequestMessage(short achievementId) {
		this.achievementId = achievementId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.achievementId = reader.readShort();
		if (achievementId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on achievementId = %s, it doesn't respect the following condition : achievementId < 0", achievementId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.achievementId);
	}
}