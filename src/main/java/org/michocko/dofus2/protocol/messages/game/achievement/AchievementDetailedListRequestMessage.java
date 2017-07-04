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
public class AchievementDetailedListRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6357;
	
	private short categoryId;
	
	public AchievementDetailedListRequestMessage() {
	}
	
	public AchievementDetailedListRequestMessage(short categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.categoryId = reader.readShort();
		if (categoryId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on categoryId = %s, it doesn't respect the following condition : categoryId < 0", categoryId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.categoryId);
	}
}