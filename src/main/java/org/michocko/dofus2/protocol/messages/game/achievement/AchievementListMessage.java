package org.michocko.dofus2.protocol.messages.game.achievement;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.achievement.AchievementRewardable;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class AchievementListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6205;
	
	private Collection<Short> finishedAchievementsIds;
	private Collection<AchievementRewardable> rewardableAchievements;
	
	public AchievementListMessage() {
	}
	
	public AchievementListMessage(Collection<Short> finishedAchievementsIds, Collection<AchievementRewardable> rewardableAchievements) {
		this.finishedAchievementsIds = finishedAchievementsIds;
		this.rewardableAchievements = rewardableAchievements;
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
		int length = reader.readUShort();
		this.finishedAchievementsIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.finishedAchievementsIds.add(entry);
		}
		length = reader.readUShort();
		this.rewardableAchievements = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AchievementRewardable entry = new AchievementRewardable();
			entry.deserialize(reader);
			this.rewardableAchievements.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.finishedAchievementsIds.size());
		for (short entry : this.finishedAchievementsIds)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.rewardableAchievements.size());
		for (AchievementRewardable entry : this.rewardableAchievements)
		{
			entry.serialize(writer);
		}
	}
}