package org.chuckame.dofus2.protocol.messages.game.achievement;

import java.util.Collection;
import java.util.LinkedList;

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
public class AchievementDetailedListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6358;
	
	private Collection<Achievement> startedAchievements;
	private Collection<Achievement> finishedAchievements;
	
	public AchievementDetailedListMessage() {
	}
	
	public AchievementDetailedListMessage(Collection<Achievement> startedAchievements, Collection<Achievement> finishedAchievements) {
		this.startedAchievements = startedAchievements;
		this.finishedAchievements = finishedAchievements;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		int length = reader.readUShort();
		this.startedAchievements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			Achievement entry = new Achievement();
			entry.deserialize(reader);
			this.startedAchievements.add(entry);
		}
		length = reader.readUShort();
		this.finishedAchievements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			Achievement entry = new Achievement();
			entry.deserialize(reader);
			this.finishedAchievements.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.startedAchievements.size());
		for (Achievement entry : this.startedAchievements)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.finishedAchievements.size());
		for (Achievement entry : this.finishedAchievements)
		{
			entry.serialize(writer);
		}
	}
}