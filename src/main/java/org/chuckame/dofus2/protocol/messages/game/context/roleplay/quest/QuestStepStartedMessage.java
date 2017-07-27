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
public class QuestStepStartedMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 6096;
	
	private int questId;
	private int stepId;
	
	public QuestStepStartedMessage() {
	}
	
	public QuestStepStartedMessage(int questId, int stepId) {
		this.questId = questId;
		this.stepId = stepId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questId = reader.readUShort();
		if (questId < 0 || questId > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on questId = %s, it doesn't respect the following condition : questId < 0 || questId > 65535", questId));
		this.stepId = reader.readUShort();
		if (stepId < 0 || stepId > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on stepId = %s, it doesn't respect the following condition : stepId < 0 || stepId > 65535", stepId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.questId);
		writer.writeUShort(this.stepId);
	}
}