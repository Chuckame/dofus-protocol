package org.chuckame.dofus2.protocol.types.game.achievement;

import java.util.Collection;
import java.util.LinkedList;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;
import org.chuckame.dofus2.protocol.types.game.achievement.AchievementObjective;
import org.chuckame.dofus2.protocol.types.game.achievement.AchievementStartedObjective;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class Achievement implements INetworkType {
	public static final short TYPE_ID = 363;
	
	private short id;
	private Collection<AchievementObjective> finishedObjective;
	private Collection<AchievementStartedObjective> startedObjectives;
	
	public Achievement() {
	}
	
	public Achievement(short id, Collection<AchievementObjective> finishedObjective, Collection<AchievementStartedObjective> startedObjectives) {
		this.id = id;
		this.finishedObjective = finishedObjective;
		this.startedObjectives = startedObjectives;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.id = reader.readShort();
		if (id < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on id = %s, it doesn't respect the following condition : id < 0", id));
		int length = reader.readUShort();
		this.finishedObjective = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AchievementObjective entry = new AchievementObjective();
			entry.deserialize(reader);
			this.finishedObjective.add(entry);
		}
		length = reader.readUShort();
		this.startedObjectives = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			AchievementStartedObjective entry = new AchievementStartedObjective();
			entry.deserialize(reader);
			this.startedObjectives.add(entry);
		}
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.id);
		writer.writeUShort(this.finishedObjective.size());
		for (AchievementObjective entry : this.finishedObjective)
		{
			entry.serialize(writer);
		}
		writer.writeUShort(this.startedObjectives.size());
		for (AchievementStartedObjective entry : this.startedObjectives)
		{
			entry.serialize(writer);
		}
	}
}