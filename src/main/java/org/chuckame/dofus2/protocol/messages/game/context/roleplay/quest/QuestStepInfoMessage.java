package org.chuckame.dofus2.protocol.messages.game.context.roleplay.quest;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.common.io.INetworkMessage;
import org.chuckame.dofus2.common.io.ProtocolTypeManager;
import org.chuckame.dofus2.protocol.types.game.context.roleplay.quest.QuestActiveInformations;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class QuestStepInfoMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5625;
	
	private QuestActiveInformations infos;
	
	public QuestStepInfoMessage() {
	}
	
	public QuestStepInfoMessage(QuestActiveInformations infos) {
		this.infos = infos;
	}
	
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	public void deserialize(IDataReader reader) {
		this.infos = ProtocolTypeManager.getInstance().<QuestActiveInformations>newInstance(reader.readShort());
		this.infos.deserialize(reader);
	}
	
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.infos.getProtocolTypeId());
		this.infos.serialize(writer);
	}
}