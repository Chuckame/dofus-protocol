package org.michocko.dofus2.protocol.messages.game.context.roleplay.quest;

import java.util.Collection;
import java.util.LinkedList;

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
public class QuestListMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5626;
	
	private Collection<Short> finishedQuestsIds;
	private Collection<Short> finishedQuestsCounts;
	private Collection<QuestActiveInformations> activeQuests;
	
	public QuestListMessage() {
	}
	
	public QuestListMessage(Collection<Short> finishedQuestsIds, Collection<Short> finishedQuestsCounts, Collection<QuestActiveInformations> activeQuests) {
		this.finishedQuestsIds = finishedQuestsIds;
		this.finishedQuestsCounts = finishedQuestsCounts;
		this.activeQuests = activeQuests;
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
		int length = reader.readUShort();
		this.finishedQuestsIds = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.finishedQuestsIds.add(entry);
		}
		length = reader.readUShort();
		this.finishedQuestsCounts = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.finishedQuestsCounts.add(entry);
		}
		length = reader.readUShort();
		this.activeQuests = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			QuestActiveInformations entry = (QuestActiveInformations) ProtocolTypeManager.getInstance().newInstance(reader.readShort());
			entry.deserialize(reader);
			this.activeQuests.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeUShort(this.finishedQuestsIds.size());
		for (short entry : this.finishedQuestsIds)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.finishedQuestsCounts.size());
		for (short entry : this.finishedQuestsCounts)
		{
			writer.writeShort(entry);
		}
		writer.writeUShort(this.activeQuests.size());
		for (QuestActiveInformations entry : this.activeQuests)
		{
			writer.writeShort(entry.getNetworkTypeId());
			entry.serialize(writer);
		}
	}
}