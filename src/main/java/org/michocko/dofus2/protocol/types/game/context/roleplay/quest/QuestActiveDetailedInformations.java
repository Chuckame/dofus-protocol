package org.michocko.dofus2.protocol.types.game.context.roleplay.quest;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.protocol.types.game.context.roleplay.quest.QuestObjectiveInformations;
import org.michocko.dofus2.protocol.types.game.context.roleplay.quest.QuestActiveInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true) 
public class QuestActiveDetailedInformations extends QuestActiveInformations {
	public static final short TYPE_ID = 382;
	
	private short stepId;
	private Collection<QuestObjectiveInformations> objectives;
	
	public QuestActiveDetailedInformations() {
	}
	
	public QuestActiveDetailedInformations(short questId, short stepId, Collection<QuestObjectiveInformations> objectives) {
		super(questId);
		this.stepId = stepId;
		this.objectives = objectives;
	}
	
	@Override
	public short getNetworkTypeId() {
		return TYPE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.stepId = reader.readShort();
		if (stepId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on stepId = %s, it doesn't respect the following condition : stepId < 0", stepId));
		int length = reader.readUShort();
		this.objectives = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			QuestObjectiveInformations entry = ProtocolTypeManager.getInstance().<QuestObjectiveInformations>newInstance(reader.readShort());
			entry.deserialize(reader);
			this.objectives.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeShort(this.stepId);
		writer.writeUShort(this.objectives.size());
		for (QuestObjectiveInformations entry : this.objectives)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}