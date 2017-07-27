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
public class QuestStartRequestMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5643;
	
	private int questId;
	
	public QuestStartRequestMessage() {
	}
	
	public QuestStartRequestMessage(int questId) {
		this.questId = questId;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questId = reader.readUShort();
		if (questId < 0 || questId > 65535)
			throw new IllegalArgumentException(String.format("Forbidden value on questId = %s, it doesn't respect the following condition : questId < 0 || questId > 65535", questId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.questId);
	}
}