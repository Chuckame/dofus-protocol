package org.michocko.dofus2.protocol.types.game.context.roleplay.quest;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.quest.QuestObjectiveInformations;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class QuestObjectiveInformationsWithCompletion extends QuestObjectiveInformations {
	public static final short TYPE_ID = 386;
	
	private short curCompletion;
	private short maxCompletion;
	
	public QuestObjectiveInformationsWithCompletion() {
	}
	
	public QuestObjectiveInformationsWithCompletion(short objectiveId, boolean objectiveStatus, Collection<String> dialogParams, short curCompletion, short maxCompletion) {
		super(objectiveId, objectiveStatus, dialogParams);
		this.curCompletion = curCompletion;
		this.maxCompletion = maxCompletion;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.curCompletion = reader.readShort();
		if (curCompletion < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on curCompletion = %s, it doesn't respect the following condition : curCompletion < 0", curCompletion));
		this.maxCompletion = reader.readShort();
		if (maxCompletion < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on maxCompletion = %s, it doesn't respect the following condition : maxCompletion < 0", maxCompletion));
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.curCompletion);
		writer.writeShort(this.maxCompletion);
	}
}