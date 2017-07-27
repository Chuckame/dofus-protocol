package org.chuckame.dofus2.protocol.messages.game.context.roleplay.quest;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class QuestObjectiveValidatedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6098;
	
	private int questId;
	private int objectiveId;
	
	public QuestObjectiveValidatedMessage() {
	}
	
	public QuestObjectiveValidatedMessage(int questId, int objectiveId) {
		this.questId = questId;
		this.objectiveId = objectiveId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questId = reader.readUShort();
		if (questId < 0 || questId > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on questId = %s, it doesn't respect the following condition : questId < 0 || questId > 65535", questId));
		this.objectiveId = reader.readUShort();
		if (objectiveId < 0 || objectiveId > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on objectiveId = %s, it doesn't respect the following condition : objectiveId < 0 || objectiveId > 65535", objectiveId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.questId);
		writer.writeUShort(this.objectiveId);
	}
}