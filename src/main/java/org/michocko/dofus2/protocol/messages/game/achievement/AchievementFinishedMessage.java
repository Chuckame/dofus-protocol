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
public class AchievementFinishedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6208;
	
	private short id;
	private short finishedlevel;
	
	public AchievementFinishedMessage() {
	}
	
	public AchievementFinishedMessage(short id, short finishedlevel) {
		this.id = id;
		this.finishedlevel = finishedlevel;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readShort();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
		this.finishedlevel = reader.readShort();
		if (finishedlevel < 0 || finishedlevel > 200)
			throw new IllegalArgumentException(String.format("Forbidden value on finishedlevel = %s, it doesn't respect the following condition : finishedlevel < 0 || finishedlevel > 200", finishedlevel));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.id);
		writer.writeShort(this.finishedlevel);
	}
}