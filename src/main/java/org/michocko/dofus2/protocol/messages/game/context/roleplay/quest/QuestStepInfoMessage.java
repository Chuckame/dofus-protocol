package org.michocko.dofus2.protocol.messages.game.context.roleplay.quest;

import org.michocko.dofus2.protocol.types.game.context.roleplay.quest.QuestActiveInformations;

import org.michocko.dofus2.common.io.ProtocolTypeManager;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

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
		this.infos = (QuestActiveInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
		this.infos.deserialize(reader);
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.infos.getNetworkTypeId());
		this.infos.serialize(writer);
	}
}