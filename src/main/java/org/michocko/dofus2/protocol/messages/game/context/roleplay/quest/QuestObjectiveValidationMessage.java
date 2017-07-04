package org.michocko.dofus2.protocol.messages.game.context.roleplay.quest;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class QuestObjectiveValidationMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6085;
	
	private short questId;
	private short objectiveId;
	
	public QuestObjectiveValidationMessage() {
	}
	
	public QuestObjectiveValidationMessage(short questId, short objectiveId) {
		this.questId = questId;
		this.objectiveId = objectiveId;
	}
	
	public int getNetworkMessageId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questId = reader.readShort();
		if (questId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on questId = %s, it doesn't respect the following condition : questId < 0", questId));
		this.objectiveId = reader.readShort();
		if (objectiveId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on objectiveId = %s, it doesn't respect the following condition : objectiveId < 0", objectiveId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.questId);
		writer.writeShort(this.objectiveId);
	}
}