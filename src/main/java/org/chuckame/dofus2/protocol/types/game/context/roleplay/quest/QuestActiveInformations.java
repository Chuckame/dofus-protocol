package org.chuckame.dofus2.protocol.types.game.context.roleplay.quest;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkType;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode 
public class QuestActiveInformations implements INetworkType {
	public static final short TYPE_ID = 381;
	
	private short questId;
	
	public QuestActiveInformations() {
	}
	
	public QuestActiveInformations(short questId) {
		this.questId = questId;
	}
	
	public short getProtocolTypeId() {
		return TYPE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.questId = reader.readShort();
		if (questId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on questId = %s, it doesn't respect the following condition : questId < 0", questId));
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.questId);
	}
}