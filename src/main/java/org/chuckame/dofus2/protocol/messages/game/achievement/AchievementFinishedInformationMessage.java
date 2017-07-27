package org.chuckame.dofus2.protocol.messages.game.achievement;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.achievement.AchievementFinishedMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class AchievementFinishedInformationMessage extends AchievementFinishedMessage {
	public static final int MESSAGE_ID = 6381;
	
	private String name;
	private int playerId;
	
	public AchievementFinishedInformationMessage() {
	}
	
	public AchievementFinishedInformationMessage(short id, short finishedlevel, String name, int playerId) {
		super(id, finishedlevel);
		this.name = name;
		this.playerId = playerId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.name = reader.readUTF();
		this.playerId = reader.readInt();
		if (playerId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on playerId = %s, it doesn't respect the following condition : playerId < 0", playerId));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeUTF(this.name);
		writer.writeInt(this.playerId);
	}
}